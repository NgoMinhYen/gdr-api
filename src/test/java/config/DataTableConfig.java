package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import dataObject.Account;
import dataObject.Lecture;
import dataObject.User;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.datatable.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class DataTableConfig implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    private <T> void register(Class<?> cls, TypeRegistry typeRegistry) {

        TableEntryTransformer<T> transformer = new TableEntryTransformer<T>() {
            @Override
            public T transform(Map entry) throws Throwable {
                return (T) new ObjectMapper().convertValue(entry, cls);
            }
        };

        DataTableType dataTableType = new DataTableType(cls, transformer);
        typeRegistry.defineDataTableType(dataTableType);
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        Transformer transformer = new Transformer();
        typeRegistry.setDefaultDataTableCellTransformer(transformer);
        typeRegistry.setDefaultDataTableEntryTransformer(transformer);
        typeRegistry.setDefaultParameterTransformer(transformer);


//        TableEntryTransformer<Account> transformerAccount = new TableEntryTransformer<Account>() {
//            @Override
//            public Account transform(Map entry) throws Throwable {
//                return new ObjectMapper().convertValue(entry, Account.class);
//            }
//        };
//
//        DataTableType dataTableType = new DataTableType(Account.class, transformerAccount);
//        typeRegistry.defineDataTableType(dataTableType);


        this.<Account>register(Account.class, typeRegistry);
        this.<Lecture>register(Lecture.class, typeRegistry);


    }


    private class Transformer implements ParameterByTypeTransformer, TableEntryByTypeTransformer, TableCellByTypeTransformer {

        ObjectMapper objectMapper = new ObjectMapper();
        @Override
        public Object transform(String fromValue, Type toValueType) throws Throwable {
            System.out.println("!!!transform(String s, Type type) ");
            return objectMapper.convertValue(fromValue, objectMapper.constructType(toValueType));
        }

        @Override
        public Object transform(Map<String, String> entryValue, Type toValueType, TableCellByTypeTransformer cellTransformer) throws Throwable {
            System.out.println("!!!transform4  ");
            return objectMapper.convertValue(entryValue, toValueType.getClass());
        }
    }


}
