package cn.itcast.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yanjing
 * @date 2022/2/27
 */
@Data
@Entity
@Table(name = "cst_customer")
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
}
