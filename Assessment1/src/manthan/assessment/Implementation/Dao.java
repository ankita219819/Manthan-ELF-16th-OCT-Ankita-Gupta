package manthan.assessment.Implementation;

import manthan.assessment.bean.Bean;

public interface Dao {
	
	public boolean addMe(Bean b);
	public Bean logIn(int uid, String password );
	public boolean update(int uid,String password);
	

}
