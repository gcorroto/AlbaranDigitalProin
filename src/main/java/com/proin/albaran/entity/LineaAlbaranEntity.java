package com.proin.albaran.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TLineaAlbaran")
@Setter
@Getter
public class LineaAlbaranEntity extends LineaAlbaranAbstract {

    @EmbeddedId
	private AlbaranEntityPK id;
}
