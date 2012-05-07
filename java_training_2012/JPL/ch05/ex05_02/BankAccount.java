package ch05.ex05_02;

public class BankAccount {

	private long number;
	private long balance;
	private Action lastAct;
	private History history = new History();

	public class Action{
		private String act;
		private long amount;

		Action(String act, long amount){
			this.act = act;
			this.amount = amount;
		}

		public String toString(){
			return number + ": " + act + " " + amount;
		}
	}


	/**
	 * ネストしたクラスにするべき
	 * 他のBankAccountオブジェクトを考慮し、staticにする必要はない
	 * @author Kyohei Mukai
	 *
	 */
	public class History{

		private final int MAX_NUMBER = 10;
		private int curNumber = -1;
		private int addNumber = 0;
		private Action[] action = new Action[MAX_NUMBER];


		public Action next(){
			if(curNumber<addNumber){
				curNumber++;
				return action[curNumber];
			}else{
				return null;
			}
		}

		public void add(Action lastAct){

			if(addNumber<MAX_NUMBER){
				action[addNumber] = lastAct;
			}else{
				for(int i=0; i<MAX_NUMBER-1; i++){
					action[i] = action[i+1];
				}
				action[MAX_NUMBER-1] = lastAct;
			}

			addNumber++;
		}

	}

	public History history(){
		return history;
	}

	public void deposit(long amount){
		balance += amount;
		lastAct = this.new Action("deposit",amount);
		history.add(lastAct);
	}

	public void withdraw(long amount){
		balance -= amount;
		lastAct = this.new Action("withdraw",amount);
		history.add(lastAct);
	}

	public long getBalance(){
		return balance;
	}

}
