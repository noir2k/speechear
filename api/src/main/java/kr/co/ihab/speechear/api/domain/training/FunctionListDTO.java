package kr.co.ihab.speechear.api.domain.training;

import lombok.Data;

import java.util.Map;

@Data
public class FunctionListDTO<K, T>  {
    private int totalPage;
    private int currentPage;

    private Map<K, T> rows;
}
