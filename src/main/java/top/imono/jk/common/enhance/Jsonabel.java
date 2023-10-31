package top.imono.jk.common.enhance;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface Jsonabel {
    default String jsonString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //  非空不生成字符串
        mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsString(this);
    }
}
