package com.ssafy.db.repository;

import com.ssafy.common.cumtomObject.RoomInfoInterface;
import com.ssafy.db.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 게임 모델 관련 디비 쿼리 생성을 위한 JPA Query Method 인터페이스 정의.
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    // 아래와 같이, Query Method 인터페이스(반환값, 메소드명, 인자) 정의를 하면 자동으로 Query Method 구현됨.

    Optional<Room> findByRoomSeq(long roomSeq);

    Optional<Room> findByRoomSeqAndMvpNull(long roomSeq);

    Optional<Room> findByRoomSeqAndMvpNotNull(long roomSeq);

    @Query(value = "select room_seq, date, host, max_capacity, mvp from room " +
            " where substring_index(date, ' ', 1) = :date " +
            " AND room_seq IN (select room_code from player where user = :nickname) " +
            " AND mvp IS NOT NULL", nativeQuery = true)
    List<RoomInfoInterface> getRoomInfoByNicknameAndDate(@Param(value = "nickname") String nickname,
                                                         @Param(value = "date") String date);

    int countAllByMvp(String nickname);
}