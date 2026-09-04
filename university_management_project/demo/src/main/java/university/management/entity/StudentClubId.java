package university.management.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StudentClubId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "club_id")
    private Long clubId;

    public StudentClubId() {
    }

    public StudentClubId(Long studentId, Long clubId) {
        this.studentId = studentId;
        this.clubId = clubId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getClubId() {
        return clubId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubId, studentId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        StudentClubId other = (StudentClubId) obj;
        return Objects.equals(clubId, other.clubId) && Objects.equals(studentId, other.studentId);
    }

}
