package com.valid.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.valid.exception.ConfigurationException;
import com.valid.model.YamlClassMethodValidation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class YamlConfigLoader {
    private static final String FILE_NOT_FOUND = "File %s not found";

    public Map<String, List<YamlClassMethodValidation>> loadJsonConfiguration(String path) throws FileNotFoundException {
        path = path.replace("%20", " ");
        TypeReference<Map<String, List<YamlClassMethodValidation>>> typeReference = new TypeReference<Map<String, List<YamlClassMethodValidation>>>() {};
        return loadConfigurationFromFile(path, typeReference);
    }

    <T> T loadConfigurationFromFile(String path, TypeReference<T> typeReference) throws FileNotFoundException {
        path = path.replace("%20", " ");
        final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());

        File pathFile = new File(path);
        if (!(pathFile.exists() && pathFile.isFile())) {
            String message = String.format(FILE_NOT_FOUND, path);
            throw new FileNotFoundException(message);
        }

        try {
            return objectMapper.readValue(pathFile, typeReference);
        } catch (IOException e) {
            throw new ConfigurationException(e);
        }
    }
}
