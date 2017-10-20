package test;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
@CrossOrigin
@ResponseBody
public class Controller {
	
	ArrayList <Service> l=new ArrayList<Service>();	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@RequestBody Service serv){
		l.add(serv);
		return "Success";
	}
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String update(@RequestBody Service serv){
		int id=serv.getId();
		Iterator<Service> itr=l.iterator();
		while(itr.hasNext()){
			Service s=itr.next();
			if(id==s.getId()){
				l.remove(s);
			}
		}
		l.add(serv);
		return "Success";

	}
	@RequestMapping("/list")
	public ArrayList<Service> display(){
		return l;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@RequestBody Service serv){
		int id=serv.getId();
		Iterator<Service> itr=l.iterator();
		while(itr.hasNext()){
			Service s=itr.next();
			if(id==s.getId()){
				l.remove(s);
			}
		}
		return "Success";

	}
	
}
