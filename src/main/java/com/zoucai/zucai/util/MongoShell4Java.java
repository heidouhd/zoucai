package com.zoucai.zucai.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBObject;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * mongo shell 转java访问mongo的对象
 */
public class MongoShell4Java {

    public static void main(String[] args) {
        String str = "db.getCollection('tbBorrowIntent').aggregate(\n" +
                "                [\n" +
                "                { $match: {\n" +
                "                \n" +
                "                nState:{$in:[-5,0,10,20,21,22,30,31,32,40,42,50]}\n" +
                "                }}\n" +
                "                ])";

//        JsonArray jsonArray = null;
//        JsonObject jsonObject = null;
//        if(new JsonParser().parse(str).isJsonArray()){
//            jsonArray =  new JsonParser().parse(str).getAsJsonArray();
//            List<DBObject> bss = new ArrayList<DBObject>(jsonArray.size());
//            jsonToBSON(jsonArray,bss);
//            for(int i =0;i<jsonArray.size();i++){
//                System.out.println(jsonArray.get(i));
//            }
//        }
//        if(new JsonParser().parse(str).isJsonObject()){
//            jsonObject =  new JsonParser().parse(str).getAsJsonObject();
//            Set<String> keys = jsonObject.keySet();
//            for(String key : keys){
//                System.out.println(jsonObject.get(key).toString());
//                System.out.println(jsonObject.toString());
//            }
//        }


        parseJson(str);
    }

    /**
     * 解析 mongoShell
     * @param mongoShell
     * @return
     */
    public static String parseJson(String mongoShell){
        int a = mongoShell.indexOf("\\.");
        String[] strs = mongoShell.split("\\.");
        if(strs.length < 3){
            return null;
        }
        String method = strs[2].substring(0,strs[2].indexOf("(")).trim().toLowerCase();
        System.out.println("方法为: " + method);
        String json = strs[2].trim().substring(strs[2].indexOf("(")+1,strs[2].length()-1);
        Document document = null;
        List<Document> documents = null;
        if((new JsonParser().parse(json)).isJsonObject()){
            document = new Document();
            JsonObject jsonObject = (JsonObject) new JsonParser().parse(json);
            jsonToDocument(jsonObject,document);
        }else if((new JsonParser().parse(json)).isJsonArray()){
            documents = new ArrayList<Document>();
            JsonArray jsonArray = (JsonArray) new JsonParser().parse(json);
            jsonToDocument(jsonArray,documents);
        }

        //普通查询
        if(method.contains("find")){
            if(new JsonParser().parse(json).isJsonObject()){


            }
        }else if(method.contains("aggregate")){ //聚合查询
//            MongoDatabase mongoDatabase = mongoCollection.getMongoDatabase();
//            AggregateIterable<Document> iterable = mongoDatabase.getCollection("tbBorrowIntent").aggregate(documents);
//            iterable.forEach(new Block<Document>() {
//                @Override
//                public void apply(final Document document) {
//                    System.out.println(document.toJson());
//                }
//            });
            System.out.println("ok");
        }

        return null;

    }

    public static void jsonToDocument(JsonObject jsonObject, Document doc) {
        Set<String> keys = jsonObject.keySet();
        for(String key : keys){
            if(jsonObject.get(key).isJsonObject()){ //是否为json对象
                DBObject bsonSub = new BasicDBObject();
                jsonToBSON(jsonObject.get(key).getAsJsonObject(),bsonSub);
                doc.put(key, bsonSub);
            }else if(jsonObject.get(key).isJsonArray()){//是否为json数组
                List<DBObject> bsonSub = new ArrayList<DBObject>();
                jsonToBSON(jsonObject.get(key).getAsJsonArray(),bsonSub);
                doc.put(key, bsonSub);
            }else{
                setJsonDocDataByType(doc,key,jsonObject.get(key).getAsJsonPrimitive());
            }
        }
    }

    public static void jsonToDocument(JsonArray jsonArray, List<Document> docs) {
        for(int i =0;i<jsonArray.size();i++){
            if(jsonArray.get(i).isJsonObject()){ //是否为json对象
                Document bsonSub = new Document();
                docs.add(bsonSub);
                jsonToDocument(jsonArray.get(i).getAsJsonObject(),bsonSub);
            }
//            else if(jsonArray.get(i).isJsonArray()){//是否为json数组
//                Document doc = docs.get(i);
//                List<Document> documentList = new ArrayList<Document>();
//                jsonToDocument(jsonArray.get(i).getAsJsonArray(),documentList);
//
//            }
        }
    }

    public static void jsonToBSON(JsonObject jsonObject, DBObject bson) {
        Set<String> keys = jsonObject.keySet();
        for(String key : keys){
            if(jsonObject.get(key).isJsonObject()){ //是否为json对象
                DBObject bsonSub = new BasicDBObject();
                jsonToBSON(jsonObject.get(key).getAsJsonObject(), bsonSub);
                bson.put(key, bsonSub);
            }else if(jsonObject.get(key).isJsonArray()){//是否为json数组
                JsonArray jsonArray = jsonObject.get(key).getAsJsonArray();
                List<DBObject> bsonsSubs = new ArrayList<DBObject>();
                List<List<DBObject>>  bsonsSubss = new ArrayList<List<DBObject>>();
                boolean flag = true;
                for(int i = 0; i < jsonArray.size(); i++) {
                    if(jsonArray.get(i).isJsonObject()){
                        BasicDBObject bs = new BasicDBObject();
                        bsonsSubs.add(bs);
                        jsonToBSON(jsonArray.get(i).getAsJsonObject(), bs);
                    }else if(jsonArray.get(i).isJsonArray()){
                        List<DBObject> bss = new ArrayList<DBObject>();
                        bsonsSubss.add(bss);
                        jsonToBSON(jsonArray.get(i).getAsJsonArray(), bss);
                    }else{
                        List list = new ArrayList();
                        jsonArrayToList(jsonArray,list);
                        bson.put(key, list.toArray());
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    bson.put(key, bsonsSubs);
                }

            }else {
//                System.out.println(jsonObject.get(key)+ ""+jsonObject.get(key));
                setJsonDataByType(bson,key, jsonObject.get(key).getAsJsonPrimitive());
            }
        }
    }

    public static void jsonToBSON(JsonArray jsonArray, List<DBObject> bsons) {
        for(int i=0;i<jsonArray.size();i++){
            DBObject bsonSub = new BasicDBObject();
            bsons.add(bsonSub);
            if(jsonArray.get(i).isJsonObject()){ //是否为json对象
                jsonToBSON(jsonArray.get(i).getAsJsonObject(), bsonSub);
            }else if(jsonArray.get(i).isJsonArray()){//是否为json数组
                JsonArray ja = jsonArray.get(i).getAsJsonArray();
                for(int j = 0; j < jsonArray.size(); j++) {
                    jsonToBSON(jsonArray.get(j).getAsJsonObject(), bsonSub);
                }
            }else{
                setJsonDataByType(bsonSub,jsonArray.get(i).getAsString(), jsonArray.get(i).getAsJsonPrimitive());
            }
        }
    }

    private static JsonArray getJsonArray(String string){
        if(new JsonParser().parse(string).isJsonArray()){
            return (JsonArray) new JsonParser().parse(string);
        }
        return null;
    }

    private static JsonObject getJsonObject(String string){
        if(new JsonParser().parse(string).isJsonObject()){
            return (JsonObject) new JsonParser().parse(string);
        }
        return null;
    }

    /**
     * 获取数据根据类型
     */
    private static void setJsonDataByType(DBObject bson,String key,JsonPrimitive jsonPrimitive){
        if(jsonPrimitive.isBoolean()){
            bson.put(key,jsonPrimitive.getAsBoolean());
        }else if(jsonPrimitive.isNumber()){
            bson.put(key,jsonPrimitive.getAsNumber());
        }else{
            bson.put(key,jsonPrimitive.getAsString());
        }
    }


    /**
     * 获取数据根据类型
     */
    private static void setJsonDocDataByType(Document bson,String key,JsonPrimitive jsonPrimitive){
        if(jsonPrimitive.isBoolean()){
            bson.put(key,jsonPrimitive.getAsBoolean());
        }else if(jsonPrimitive.isNumber()){
            bson.put(key,jsonPrimitive.getAsNumber());
        }else {
            bson.put(key,jsonPrimitive.getAsString());
        }
    }

    private static void jsonArrayToList(JsonArray jsonArray,List list){
        for(int i=0;i<jsonArray.size();i++){
            JsonPrimitive jsonPrimitive = jsonArray.get(i).getAsJsonPrimitive();
            if(jsonPrimitive.isBoolean()){
                list.add(jsonPrimitive.getAsBoolean());
            }else if(jsonPrimitive.isNumber()){
                list.add(jsonPrimitive.getAsNumber());
            }else {
                list.add(jsonPrimitive.getAsString());
            }
        }
    }
}
