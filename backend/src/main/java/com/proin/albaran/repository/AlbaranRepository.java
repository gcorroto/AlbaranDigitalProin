package com.proin.albaran.repository;

import com.proin.albaran.entity.AlbaranEntity;
import com.proin.albaran.entity.AlbaranEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbaranRepository extends JpaRepository<AlbaranEntity, AlbaranEntityPK>{

    @Query("SELECT a FROM AlbaranEntity a " +
            "JOIN FETCH a.descripcionHormigon do " +
            "JOIN FETCH a.evaluacionMeteorologica em " +
            "JOIN FETCH a.lineasAlbaran la " +
            "WHERE  a.idAlbaran.numeroAlbaran = :numeroAlbaran AND a.idAlbaran.centro = :centro " +
                    "AND a.idAlbaran.codigoPlanta = :codigoPlanta AND a.idAlbaran.serie = :serie")
    public Optional<AlbaranEntity> findByIdJoinConsJoinDescHorJoinEvMetJoinLinA(String numeroAlbaran, String centro, String codigoPlanta, String serie);
}
