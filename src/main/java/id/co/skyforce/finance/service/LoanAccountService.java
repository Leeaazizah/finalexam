package id.co.skyforce.finance.service;

import id.co.skyforce.finance.model.CIF;
import id.co.skyforce.finance.model.LoanAccount;
import id.co.skyforce.finance.model.User;
import id.co.skyforce.finance.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LoanAccountService {
	Transaction transaction = null;
	Session session;

	public void addAcount(LoanAccount loanAccount) {
		session = HibernateUtil.openSession();
		try {
			transaction = session.beginTransaction();
			session.save(loanAccount);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
	}

	public void updateAccount(LoanAccount loanAccount) {
		session = HibernateUtil.openSession();
		try {
			transaction = session.beginTransaction();
			session.save(loanAccount);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
	}

	public void deleteAccount(String accountNumber) {
		session = HibernateUtil.openSession();
		try {
			transaction = session.beginTransaction();
			LoanAccount loanAccount = (LoanAccount) session.get(
					LoanAccount.class, accountNumber);
			session.delete(loanAccount);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}

	public List<LoanAccount> getAllLoanAccount() {
		List<LoanAccount> loanAccounts = new ArrayList<>();
		session = HibernateUtil.openSession();
		try {
			transaction = session.beginTransaction();
			loanAccounts = session.createQuery("FROM LoanAccount").list();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		session.close();
		return loanAccounts;
	}
	
	public LoanAccount getAccountNo(String accountNo){
		Transaction transaction = null;
		Session session = HibernateUtil.openSession();
		LoanAccount loanAccount = null;

		try {
			transaction = session.beginTransaction();
			loanAccount = (LoanAccount) session.get(LoanAccount.class, accountNo);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return loanAccount;
	}

	// TODO Test
	public LoanAccount getLoanAccount(String accountNo) throws Exception {
		LoanAccount loanAccount = new LoanAccount();
		session = HibernateUtil.openSession();

		try {
			transaction = session.beginTransaction();
			loanAccount = (LoanAccount) session.get(LoanAccount.class,
					accountNo);
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		}

		session.close();
		return loanAccount;
	}
	
	public LoanAccount getLoanAccountt(String accountNo){
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();
		LoanAccount loanAccountt = new LoanAccount();
		try{
			Query query = session.createQuery("from LoanAccount m where m.accountNo = :accountNo");
			query.setString("accountNo", accountNo);
			LoanAccount loanAccount = (LoanAccount) query.uniqueResult();
				loanAccount.getPlafond();
				loanAccount.getTenure();
				loanAccount.getInterestRate();
				loanAccount.getInterestType();
				trx.commit();
		}
		catch (Exception e) {
			trx.rollback();
			throw e;
		}
		session.close();
		return loanAccountt;
	}

}
