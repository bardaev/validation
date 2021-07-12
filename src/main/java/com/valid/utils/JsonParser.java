package com.valid.utils;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class JsonParser {
    public static Map<String, String> parseJson(String json) throws IOException {
        Map<String, String> keys = new HashMap<>();

        JsonReader jsonReader = new JsonReader(new StringReader(json));
        keys = handleJson(jsonReader, keys);

        return keys;
    }

    private static Map<String, String> handleJson(JsonReader reader, Map<String, String> keys) throws IOException {
        while (reader.hasNext())
        {
            JsonToken nextToken = reader.peek();
            if (JsonToken.BEGIN_OBJECT.equals(nextToken)) {
                reader.beginObject();
            } else if (JsonToken.NAME.equals(nextToken)) {
                String name = reader.nextName();
            } else if (JsonToken.STRING.equals(nextToken)) {
                String value = reader.nextString();
                keys.put(getPath(reader.getPath()), value);
            } else if (JsonToken.NUMBER.equals(nextToken)) {
                long value = reader.nextLong();
                keys.put(getPath(reader.getPath()), Long.toString(value));
            } else if (JsonToken.NULL.equals(nextToken)) {
                reader.nextNull();
                keys.put(getPath(reader.getPath()), null);
            } else if (JsonToken.END_OBJECT.equals(nextToken)) {
                reader.endObject();
            }
        }

        return keys;
    }

    private static String getPath(String path) {
        return path.replace("$.", "");
    }

}
