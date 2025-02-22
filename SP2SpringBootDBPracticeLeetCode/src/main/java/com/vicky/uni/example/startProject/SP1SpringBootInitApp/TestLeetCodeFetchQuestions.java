package com.vicky.uni.example.startProject.SP1SpringBootInitApp;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class TestLeetCodeFetchQuestions {
    private static String request = "{\n" +
            "  \"query\": \"\\n    query problemsetPanelQuestionList($filters: QuestionFilterInput, $searchKeyword: String, $sortBy: QuestionSortByInput, $categorySlug: String, $limit: Int, $skip: Int) {\\n  problemsetPanelQuestionList(\\n    filters: $filters\\n    searchKeyword: $searchKeyword\\n    sortBy: $sortBy\\n    categorySlug: $categorySlug\\n    limit: $limit\\n    skip: $skip\\n  ) {\\n    questions {\\n      id\\n      titleSlug\\n      title\\n      translatedTitle\\n      questionFrontendId\\n      paidOnly\\n      difficulty\\n      topicTags {\\n        name\\n        slug\\n        nameTranslated\\n      }\\n      status\\n      isInMyFavorites\\n      frequency\\n      acRate\\n    }\\n    totalLength\\n    finishedLength\\n    panelName\\n    hasMore\\n  }\\n}\\n    \",\n" +
            "  \"variables\": {\n" +
            "    \"skip\": SKIP_STARTING_COUNT,\n" +
            "    \"limit\": 100,\n" +
            "    \"categorySlug\": \"\",\n" +
            "    \"filters\": {\n" +
            "      \"filterCombineType\": \"ALL\",\n" +
            "      \"statusFilter\": {\n" +
            "        \"questionStatuses\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      },\n" +
            "      \"difficultyFilter\": {\n" +
            "        \"difficulties\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      },\n" +
            "      \"languageFilter\": {\n" +
            "        \"languageSlugs\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      },\n" +
            "      \"topicFilter\": {\n" +
            "        \"topicSlugs\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      },\n" +
            "      \"acceptanceFilter\": {},\n" +
            "      \"frequencyFilter\": {},\n" +
            "      \"lastSubmittedFilter\": {},\n" +
            "      \"publishedFilter\": {},\n" +
            "      \"companyFilter\": {\n" +
            "        \"companySlugs\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      },\n" +
            "      \"positionFilter\": {\n" +
            "        \"positionSlugs\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      },\n" +
            "      \"premiumFilter\": {\n" +
            "        \"premiumStatus\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      }\n" +
            "    },\n" +
            "    \"searchKeyword\": \"\",\n" +
            "    \"sortBy\": {\n" +
            "      \"sortField\": \"CUSTOM\",\n" +
            "      \"sortOrder\": \"ASCENDING\"\n" +
            "    },\n" +
            "    \"options\": {\n" +
            "      \"enabled\": true\n" +
            "    },\n" +
            "    \"filtersV2\": {\n" +
            "      \"filterCombineType\": \"ALL\",\n" +
            "      \"statusFilter\": {\n" +
            "        \"questionStatuses\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      },\n" +
            "      \"difficultyFilter\": {\n" +
            "        \"difficulties\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      },\n" +
            "      \"languageFilter\": {\n" +
            "        \"languageSlugs\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      },\n" +
            "      \"topicFilter\": {\n" +
            "        \"topicSlugs\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      },\n" +
            "      \"acceptanceFilter\": {},\n" +
            "      \"frequencyFilter\": {},\n" +
            "      \"lastSubmittedFilter\": {},\n" +
            "      \"publishedFilter\": {},\n" +
            "      \"companyFilter\": {\n" +
            "        \"companySlugs\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      },\n" +
            "      \"positionFilter\": {\n" +
            "        \"positionSlugs\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      },\n" +
            "      \"premiumFilter\": {\n" +
            "        \"premiumStatus\": [],\n" +
            "        \"operator\": \"IS\"\n" +
            "      }\n" +
            "    }\n" +
            "  },\n" +
            "  \"operationName\": \"problemsetPanelQuestionList\"\n" +
            "}";

    public static void main(String[] args) throws SQLException {
        // Predefined JSON as a String
        String predefinedJson = request;
        DataSource ds = dataSource();
        Connection connection = ds.getConnection();
        for(int i=0; i< 10000; i+=100) {
            String newQuery = new String(predefinedJson);
            newQuery = newQuery.replaceAll("SKIP_STARTING_COUNT",String.valueOf(i));
            Question[] questions = getFromServer(newQuery);
            persistInDb(connection, questions);
        }
    }

    public static Question[] getFromServer(String queryJson) {
        Question[] questObjArray = null;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // Define the URL
            HttpPost httpPost = new HttpPost("https://leetcode.com/graphql/");

            // Set the predefined JSON as the request body
            StringEntity entity = new StringEntity(queryJson);
            httpPost.setEntity(entity);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Accept", "application/json");

            // Send the request
            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                int statusCode = response.getCode();
                if (statusCode == 200) { // HTTP 200 OK
                    // Read the response body
                    String jsonResponse = EntityUtils.toString(response.getEntity());
                    JSONObject jsonObject = new JSONObject(jsonResponse);
                    JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONObject("problemsetPanelQuestionList").getJSONArray("questions");
                    String questionsArray = jsonArray.toString();
                    ObjectMapper mapper = new ObjectMapper();
                    questObjArray = mapper.readValue(questionsArray, Question[].class);
                    System.out.println(questionsArray);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return questObjArray;
    }

    private static DataSource dataSource() {
        /*HikariConfig config = new HikariConfig();
        //config.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
        config.setUsername(System.getenv("SYSTEM"));
        config.setPassword(System.getenv("manager"));
        config.setMaximumPoolSize(50);
        config.addDataSourceProperty("oracle.jdbc.defaultConnectionValidation", "LOCAL");
        return new HikariDataSource(config);*/
        // 1. Configure HikariCP
        HikariConfig config = new HikariConfig();

        // Database connection details
        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1"); // Or SID format
        config.setUsername("SYSTEM");
        config.setPassword("manager");

        // HikariCP pool settings (tune these as needed)
        config.setMinimumIdle(5); // Minimum number of idle connections
        config.setMaximumPoolSize(20); // Maximum number of connections
        config.setConnectionTimeout(30000); // Connection timeout in milliseconds
        config.setIdleTimeout(600000); // Idle timeout in milliseconds
        config.setMaxLifetime(1800000); // Maximum lifetime of a connection in milliseconds
        config.setPoolName("OracleConnectionPool"); // Give your pool a name
        config.setLeakDetectionThreshold(10000); // Detect connection leaks (optional)

        // Oracle specific settings (highly recommended)
        config.addDataSourceProperty("oracle.net.CONNECT_TIMEOUT", "30000");  // Connection timeout
        config.addDataSourceProperty("oracle.net.READ_TIMEOUT", "30000");     // Read timeout

        // 2. Create the HikariDataSource
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }
    private static void persistInDb(Connection conn, Question[] questions) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("insert into VJ_LEETCODE.QUESTIONS (id, difficulty, title, titleSlug, topicTags) values (?,?,?,?,?)");
        for(Question question : questions) {
            preparedStatement.setInt(1, question.getId());
            preparedStatement.setString(2, question.getDifficulty());
            preparedStatement.setString(3, question.getTitle());
            preparedStatement.setString(4, question.getTitleSlug());
            preparedStatement.setString(5, question.getTopicTags().stream().map(CommonTagNode::getName).collect(Collectors.joining(",")));
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
    }
}
