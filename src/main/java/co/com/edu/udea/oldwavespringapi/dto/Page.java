package co.com.edu.udea.oldwavespringapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class Page {
    List<Item> items;
    Integer total;
    Integer page;
    Integer size;
}
