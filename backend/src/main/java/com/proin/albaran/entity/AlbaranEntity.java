package com.proin.albaran.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TAlbaran")
@Setter
@Getter
public class AlbaranEntity {
	
	@EmbeddedId
	private AlbaranEntityPK idAlbaran;
	
    @Column(name = "albaranid")
    private String albaranid;
	
}
