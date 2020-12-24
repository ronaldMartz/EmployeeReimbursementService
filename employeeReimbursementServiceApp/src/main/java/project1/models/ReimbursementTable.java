package project1.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "REIMBURSEMENT")
public class ReimbursementTable {
    //ReimbursementTable Class info from the reimbursement table
    @Id
    @Column(name = "REQUEST_ID", columnDefinition = "serial primary key")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer request_id;

    @Column(name = "REQUEST_DATE")
    private String request_date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "REQUESTING_ID", referencedColumnName = "EMPLOYEE_ID", columnDefinition = "INT")
    private EmployeeTable requesting_id;

    @Column(name = "REQUEST_AMOUNT")
    private Double request_amount;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "RESOLUTION")
    private String resolution;

    @Column(name = "RESOLUTION_NOTES")
    private String resolution_notes;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "RESOLVED_BY", referencedColumnName = "EMPLOYEE_ID", columnDefinition = "INT")
    private EmployeeTable resolved_by;

    @Column(name = "RESOLUTION_DATE")
    private String resolution_date;

    public ReimbursementTable() {
    }

    public Integer getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Integer request_id) {
        this.request_id = request_id;
    }

    public String getRequest_date() {
        return request_date;
    }

    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }

    public EmployeeTable getRequesting_id() {
        return requesting_id;
    }

    public void setRequesting_id(EmployeeTable requesting_id) {
        this.requesting_id = requesting_id;
    }

    public Double getRequest_amount() {
        return request_amount;
    }

    public void setRequest_amount(Double request_amount) {
        this.request_amount = request_amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getResolution_notes() { return resolution_notes; }

    public void setResolution_notes(String resolution_notes) {
        this.resolution_notes = resolution_notes;
    }

    public EmployeeTable getResolved_by() {
        return resolved_by;
    }

    public void setResolved_by(EmployeeTable resolved_by) {
        this.resolved_by = resolved_by;
    }

    public String getResolution_date() {
        return resolution_date;
    }

    public void setResolution_date(String resolution_date) {
        this.resolution_date = resolution_date;
    }

    @Override
    public String toString() {
        return "ReimbursementTable{" +
                "request_id=" + request_id +
                ", request_date='" + request_date + '\'' +
                ", requesting_id=" + requesting_id +
                ", request_amount=" + request_amount +
                ", reason='" + reason + '\'' +
                ", resolution='" + resolution + '\'' +
                ", resolution_notes='" + resolution_notes + '\'' +
                ", resolved_by=" + resolved_by +
                ", resolution_date='" + resolution_date + '\'' +
                '}';
    }
}
