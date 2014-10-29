package id.co.skyforce.finance.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

import id.co.skyforce.finance.model.CIF;
import id.co.skyforce.finance.model.LoanAccount;
import id.co.skyforce.finance.model.LoanAccountSchedule;
import id.co.skyforce.finance.model.Payment;
import id.co.skyforce.finance.service.CIFService;
import id.co.skyforce.finance.service.LoanAccountScheduleService;
import id.co.skyforce.finance.service.LoanAccountService;
import id.co.skyforce.finance.service.LoginService;
import id.co.skyforce.finance.util.HibernateUtil;

@ManagedBean
@ViewScoped
public class ViewAccountController {
	
	private String cifNo;
	private String accountNo;
	private BigDecimal plafond;
	private Integer tenure;
	private BigDecimal interestRate;
	private Character interestType;

	
	private List<LoanAccount> loanAccounts;
	private CIF cif;
	private CIFService cifService;
	LoanAccount loanAccount = new LoanAccount();
	
	private Integer noAccount;
	
	private Integer period;
	private Date dueDate;
	private BigDecimal principal;
	private BigDecimal interest;
	private BigDecimal installment;
	private BigDecimal outstanding;
	private Character paidStatus;
	
	public ViewAccountController() throws Exception{
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("accountNo");

		if (id != null) {
			noAccount = Integer.valueOf(id);
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();

			LoanAccount viewLoan = (LoanAccount) session.get(LoanAccount.class, noAccount);

			this.cifNo = viewLoan.getAccountNo();
			this.accountNo = viewLoan.getAccountNo();
			this.plafond = viewLoan.getPlafond();
			this.tenure = viewLoan.getTenure();
			this.interestRate = viewLoan.getInterestRate();
			this.interestType = viewLoan.getInterestType();
			

			LoanAccountService loanAccountService = new LoanAccountService();
			loanAccountService.getLoanAccount(accountNo);
			LoanAccountScheduleService.generateSchedule(viewLoan);
			trx.commit();
			session.close();
		}
	}


	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public BigDecimal getPlafond() {
		return plafond;
	}

	public void setPlafond(BigDecimal plafond) {
		this.plafond = plafond;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public BigDecimal getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}

	public Character getInterestType() {
		return interestType;
	}

	public void setInterestType(Character interestType) {
		this.interestType = interestType;
	}

	public String getCifNo() {
		return cifNo;
	}

	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}

	

	public List<LoanAccount> getLoanAccounts() {
		return loanAccounts;
	}






















	public void setLoanAccounts(List<LoanAccount> loanAccounts) {
		this.loanAccounts = loanAccounts;
	}






















	public CIF getCif() {
		return cif;
	}

	public void setCif(CIF cif) {
		this.cif = cif;
	}

	public CIFService getCifService() {
		return cifService;
	}

	public void setCifService(CIFService cifService) {
		this.cifService = cifService;
	}

	public LoanAccount getLoanAccount() {
		return loanAccount;
	}

	public void setLoanAccount(LoanAccount loanAccount) {
		this.loanAccount = loanAccount;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getPrincipal() {
		return principal;
	}

	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public BigDecimal getInstallment() {
		return installment;
	}

	public void setInstallment(BigDecimal installment) {
		this.installment = installment;
	}

	public BigDecimal getOutstanding() {
		return outstanding;
	}

	public void setOutstanding(BigDecimal outstanding) {
		this.outstanding = outstanding;
	}

	public Character getPaidStatus() {
		return paidStatus;
	}

	public void setPaidStatus(Character paidStatus) {
		this.paidStatus = paidStatus;
	}
	
	
	
	

}
