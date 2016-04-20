package model;

import java.sql.Timestamp;

/**
 * Created by Santiago Martí Olbrich (samarti@uc.cl) on 4/20/16.
 * Resit SpA.
 * All rights reserved
 */
public class Task {
    int id, father_checklist;
    Timestamp created, deadline, estimated_start_date, true_start_date;
    String description, domain, name, privacy, status, task_type;

    public Task(int id, int father_checklist, Timestamp created, Timestamp deadline,
                Timestamp estimated_start_date, Timestamp true_start_date, String description,
                String domain, String name, String privacy, String status, String task_type) {
        this.id = id;
        this.father_checklist = father_checklist;
        this.created = created;
        this.deadline = deadline;
        this.estimated_start_date = estimated_start_date;
        this.true_start_date = true_start_date;
        this.description = description;
        this.domain = domain;
        this.name = name;
        this.privacy = privacy;
        this.status = status;
        this.task_type = task_type;
    }
}
