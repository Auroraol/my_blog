package com.lfj.blog.controller.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 2019-11-28 19:17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticlePageQueryDTO {

	private Long current;

	private Long size;

	private Integer categoryId;

	private Integer tagId;

	private String yearMonth;

	private String title;

	private String sort;
}
