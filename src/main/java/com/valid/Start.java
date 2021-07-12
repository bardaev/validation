package com.valid;

import com.google.gson.Gson;
import com.valid.config.YamlConfigLoader;
import com.valid.model.YamlClassMethodValidation;
import com.valid.utils.JsonParser;
import com.valid.utils.Validation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Start {
    public static void main(String[] args) throws IOException {
        YamlConfigLoader yamlConfigLoader = new YamlConfigLoader();
        Map<String, List<YamlClassMethodValidation>> config = yamlConfigLoader.loadJsonConfiguration("config/config.yaml");

        BufferedReader bf = new BufferedReader(new FileReader("config/data.json"));

        String line;
        while ((line = bf.readLine()) != null) {
            Map<String, String> json = JsonParser.parseJson(line);
            Validation.validation(config, json);
        }

    }
}
