package com.lfj.blog.controller.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分类节点
 * <p>
 * 2019-11-14 17:38
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryNodeDTO {

	@ApiModelProperty(value = "id")
	private Integer id;

	@ApiModelProperty(value = "名称")
	private String name;

	@ApiModelProperty(value = "父类id")
	private Integer parentId;

	@ApiModelProperty(value = "子目录")
	private List<CategoryNodeDTO> children;
}
