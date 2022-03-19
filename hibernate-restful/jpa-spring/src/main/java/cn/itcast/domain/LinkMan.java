package cn.itcast.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author yanjing
 * @date 2022/3/19
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "cst_linkman")
public class LinkMan implements Serializable {

    private static final long serialVersionUID = -3056220485027253114L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="lkm_id")
    private Long lkmId;
    @Column(name="lkm_name")
    private String lkmName;
    @Column(name="lkm_gender")
    private String lkmGender;
    @Column(name="lkm_phone")
    private String lkmPhone;
    @Column(name="lkm_mobile")
    private String lkmMobile;
    @Column(name="lkm_email")
    private String lkmEmail;
    @Column(name="lkm_position")
    private String lkmPosition;
    @Column(name="lkm_memo")
    private String lkmMemo;

    @ManyToOne
    @JoinColumn(name="lkm_cust_id")
    private Customer customer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LinkMan linkMan = (LinkMan) o;
        return lkmId != null && Objects.equals(lkmId, linkMan.lkmId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
