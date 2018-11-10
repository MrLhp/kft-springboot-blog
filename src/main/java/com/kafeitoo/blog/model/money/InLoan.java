package com.kafeitoo.blog.model.money;

import com.kafeitoo.blog.enums.LoanSource;
import com.kafeitoo.blog.enums.LoanType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 贷款
 */
@Getter
@Setter
@Entity
public class InLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 序号
     */
    @NotBlank
    @Column
    int no;
    /**
     * 周期
     */
    @NotBlank
    @Column
    int days;
    /**
     * 还款日
     */
    @Temporal(TemporalType.DATE)
    Date repaymentDate;
    /**
     * 还款额（x100）
     */
    Long repaymentMoney;
    /**
     * 本金（x100）
     */
    Long principal;
    /**
     * 利息（x100）
     */
    Long interest;
    /**
     * 剩下待还（x100）
     */
    Long amountMoney;
    /**
     * 用户Id
     */
    @NotBlank
    Long userId;
    /**
     * 贷款来源
     */
    @NotBlank
    LoanSource loanSource;
    /**
     * 贷款来源
     */
    @NotBlank
    LoanType loanType;

}
