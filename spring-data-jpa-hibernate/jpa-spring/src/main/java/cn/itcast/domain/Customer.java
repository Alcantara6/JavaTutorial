package cn.itcast.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author yanjing
 * @date 2022/2/27
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "cst_customer")
@NamedEntityGraph(
        name = "customer-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("linkmans")
        }
)
public class Customer implements Serializable {

    private static final long serialVersionUID = -4148807949961120856L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_source")
    private String custSource;

    @Column(name = "cust_industry")
    private String custIndustry;

    @Column(name = "cust_level")
    private String custLevel;

    @Column(name = "cust_address")
    private String custAddress;

    @Column(name = "cust_phone")
    private String custPhone;

    @OneToMany(
            mappedBy = "customer",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    // 注意，防止打印的时候循环依赖
    @ToString.Exclude
    private Set<LinkMan> linkmans = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Customer customer = (Customer) o;
        return custId != null && Objects.equals(custId, customer.custId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
