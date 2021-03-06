package com.pancaker.pancake.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jianbinggouzi on 19-5-5.
 */
@Entity
public class Board extends BaseDomain {
    @Id
    private String boardId;
    @Property(nameInDb = "board_name")
    private String boardName;
    @Property(nameInDb = "board_desc")
    private String boardDesc;
    @Property(nameInDb = "letter_num")
    private long letterNum;

    @Generated(hash = 173710555)
    public Board(String boardId, String boardName, String boardDesc,
            long letterNum) {
        this.boardId = boardId;
        this.boardName = boardName;
        this.boardDesc = boardDesc;
        this.letterNum = letterNum;
    }

    @Generated(hash = 1406520307)
    public Board() {
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public void setBoardDesc(String boardDesc) {
        this.boardDesc = boardDesc;
    }

    public void setLetterNum(long letterNum) {
        this.letterNum = letterNum;
    }

    public String getBoardId() {
        return boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public String getBoardDesc() {
        return boardDesc;
    }

    public long getLetterNum() {
        return letterNum;
    }
}

