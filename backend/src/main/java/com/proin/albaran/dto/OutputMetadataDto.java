package com.proin.albaran.dto;

import com.proin.albaran.constantes.MetadataAlbaranEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OutputMetadataDto {

	private String name;
	private String displayName;
	private String groupName;
	private Integer index;
	private String editor;


	public OutputMetadataDto(MetadataAlbaranEnum meta) {
		this.name=meta.getName();
		this.displayName=meta.getDisplayName();
		this.groupName=meta.getGroupName();
		this.index=meta.getIndex();
		this.editor=meta.getEditor();
	}


}
