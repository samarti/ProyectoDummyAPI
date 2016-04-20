package model;

import java.sql.Timestamp;

/**
 * Created by Santiago Martí Olbrich (samarti@uc.cl) on 4/18/16.
 * Resit SpA.
 * All rights reserved
 */
public class Announcement {

    Integer id, board, executive;
    int[] document;
    Timestamp created;
    String message;
    boolean technical_check, venture_check, financial_check;

    public Announcement(Integer id, Integer board, Integer executive, int[] document,
                        Timestamp created, String message, boolean technical_check, boolean venture_check, boolean financial_check) {
        this.id = id;
        this.board = board;
        this.executive = executive;
        this.document = document;
        this.created = created;
        this.message = message;
        this.technical_check = technical_check;
        this.venture_check = venture_check;
        this.financial_check = financial_check;
    }
}
