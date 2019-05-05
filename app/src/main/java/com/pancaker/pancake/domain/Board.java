package com.pancaker.pancake.domain;

/**
 * Created by jianbinggouzi on 19-5-5.
 */

public class Board extends BaseDomain {

    private String boardId;

    private String boardName;

    private String boardDesc;

    private long letterNum;

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

