package example.service.impl;

import example.service.NameService;

public class NameServiceImpl implements NameService {

	@Override
	public boolean checkName(String name) {
		String[] nameArr = {"jack","tom","lily"};
		for(int i=0;i<nameArr.length;i++){
			if(name.equals(nameArr[i])){
				return true;
			}
		}
		return false;
	}

}
