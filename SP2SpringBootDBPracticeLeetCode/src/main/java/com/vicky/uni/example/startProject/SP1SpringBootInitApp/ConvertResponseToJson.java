package com.vicky.uni.example.startProject.SP1SpringBootInitApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConvertResponseToJson {
    public static void main(String[] args) throws JsonProcessingException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JSONObject jsonObject = new JSONObject(jsonResponse);
            JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONObject("problemsetPanelQuestionList").getJSONArray("questions");
            String questionsArray = jsonArray.toString();
            Question[] questObjArray = mapper.readValue(questionsArray, Question[].class);
            System.out.println(questionsArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String jsonResponse = "{\n" +
            "  \"data\": {\n" +
            "    \"problemsetPanelQuestionList\": {\n" +
            "      \"questions\": [\n" +
            "        {\n" +
            "          \"difficulty\": \"EASY\",\n" +
            "          \"id\": 1,\n" +
            "          \"paidOnly\": false,\n" +
            "          \"questionFrontendId\": \"1\",\n" +
            "          \"status\": \"TO_DO\",\n" +
            "          \"title\": \"Two Sum\",\n" +
            "          \"titleSlug\": \"two-sum\",\n" +
            "          \"topicTags\": [\n" +
            "            {\n" +
            "              \"name\": \"Array\",\n" +
            "              \"slug\": \"array\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"name\": \"Hash Table\",\n" +
            "              \"slug\": \"hash-table\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"frequency\": null,\n" +
            "          \"isInMyFavorites\": false,\n" +
            "          \"acRate\": 0.5484231865429324,\n" +
            "          \"__typename\": \"ProblemSetQuestionNode\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"difficulty\": \"MEDIUM\",\n" +
            "          \"id\": 2,\n" +
            "          \"paidOnly\": false,\n" +
            "          \"questionFrontendId\": \"2\",\n" +
            "          \"status\": \"TO_DO\",\n" +
            "          \"title\": \"Add Two Numbers\",\n" +
            "          \"titleSlug\": \"add-two-numbers\",\n" +
            "          \"topicTags\": [\n" +
            "            {\n" +
            "              \"name\": \"Linked List\",\n" +
            "              \"slug\": \"linked-list\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"name\": \"Math\",\n" +
            "              \"slug\": \"math\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"name\": \"Recursion\",\n" +
            "              \"slug\": \"recursion\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"frequency\": null,\n" +
            "          \"isInMyFavorites\": false,\n" +
            "          \"acRate\": 0.4521162410473938,\n" +
            "          \"__typename\": \"ProblemSetQuestionNode\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"difficulty\": \"MEDIUM\",\n" +
            "          \"id\": 19,\n" +
            "          \"paidOnly\": false,\n" +
            "          \"questionFrontendId\": \"19\",\n" +
            "          \"status\": \"TO_DO\",\n" +
            "          \"title\": \"Remove Nth Node From End of List\",\n" +
            "          \"titleSlug\": \"remove-nth-node-from-end-of-list\",\n" +
            "          \"topicTags\": [\n" +
            "            {\n" +
            "              \"name\": \"Linked List\",\n" +
            "              \"slug\": \"linked-list\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"name\": \"Two Pointers\",\n" +
            "              \"slug\": \"two-pointers\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"frequency\": null,\n" +
            "          \"isInMyFavorites\": false,\n" +
            "          \"acRate\": 0.4786517049876434,\n" +
            "          \"__typename\": \"ProblemSetQuestionNode\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"difficulty\": \"EASY\",\n" +
            "          \"id\": 20,\n" +
            "          \"paidOnly\": false,\n" +
            "          \"questionFrontendId\": \"20\",\n" +
            "          \"status\": \"TO_DO\",\n" +
            "          \"title\": \"Valid Parentheses\",\n" +
            "          \"titleSlug\": \"valid-parentheses\",\n" +
            "          \"topicTags\": [\n" +
            "            {\n" +
            "              \"name\": \"String\",\n" +
            "              \"slug\": \"string\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"name\": \"Stack\",\n" +
            "              \"slug\": \"stack\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"frequency\": null,\n" +
            "          \"isInMyFavorites\": false,\n" +
            "          \"acRate\": 0.41700845987797275,\n" +
            "          \"__typename\": \"ProblemSetQuestionNode\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"difficulty\": \"EASY\",\n" +
            "          \"id\": 21,\n" +
            "          \"paidOnly\": false,\n" +
            "          \"questionFrontendId\": \"21\",\n" +
            "          \"status\": \"TO_DO\",\n" +
            "          \"title\": \"Merge Two Sorted Lists\",\n" +
            "          \"titleSlug\": \"merge-two-sorted-lists\",\n" +
            "          \"topicTags\": [\n" +
            "            {\n" +
            "              \"name\": \"Linked List\",\n" +
            "              \"slug\": \"linked-list\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"name\": \"Recursion\",\n" +
            "              \"slug\": \"recursion\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"frequency\": null,\n" +
            "          \"isInMyFavorites\": false,\n" +
            "          \"acRate\": 0.6610602712687917,\n" +
            "          \"__typename\": \"ProblemSetQuestionNode\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"difficulty\": \"MEDIUM\",\n" +
            "          \"id\": 22,\n" +
            "          \"paidOnly\": false,\n" +
            "          \"questionFrontendId\": \"22\",\n" +
            "          \"status\": \"TO_DO\",\n" +
            "          \"title\": \"Generate Parentheses\",\n" +
            "          \"titleSlug\": \"generate-parentheses\",\n" +
            "          \"topicTags\": [\n" +
            "            {\n" +
            "              \"name\": \"String\",\n" +
            "              \"slug\": \"string\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"name\": \"Dynamic Programming\",\n" +
            "              \"slug\": \"dynamic-programming\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            },\n" +
            "            {\n" +
            "              \"name\": \"Backtracking\",\n" +
            "              \"slug\": \"backtracking\",\n" +
            "              \"__typename\": \"CommonTagNode\"\n" +
            "            }\n" +
            "          ],\n" +
            "          \"frequency\": null,\n" +
            "          \"isInMyFavorites\": false,\n" +
            "          \"acRate\": 0.7634927569203198,\n" +
            "          \"__typename\": \"ProblemSetQuestionNode\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"totalLength\": 3445,\n" +
            "      \"finishedLength\": 0,\n" +
            "      \"panelName\": \"Problem List\",\n" +
            "      \"hasMore\": true\n" +
            "    }\n" +
            "  }\n" +
            "}";

}
