package gzrd.wsclient.post;

import gzrd.wsclient.menu.wsinterface.Menu;
import gzrd.wsclient.menu.wsinterface.MenuWebService;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 
 * @author hegc 2013骞?链?7镞?涓婂崃11:33:41
 * 娴嬭瘯鐢熸垚鍑烘潵镄克ebservice瀹㈡埛绔兘鍚﹁闂?
 */
public class Test {

	/*
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		
		 // 娉ㄥ唽WebService鎺ュ彛
		factory.setServiceClass(PositionWebService.class);
		
		String wdsl = "http://10.0.8.39/opus/ws/PositionWebService";
		
		factory.setAddress(wdsl);
		
		PositionWebService iPost = (PositionWebService) factory.create();
		
		Position dto = iPost.getPositionById(588);
		
	
		System.out.println(dto);
		
		System.out.println(dto.getPosName() + dto.getOrgId() + dto.getOrgName());
	}*/
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-webservice.xml");
		
		PositionWebService iPost = context.getBean("postWsClient", PositionWebService.class);
		
		//阃氲绷宀椾綅缂栧佛銮峰缑鍗曚綅缂栧佛, 鍗曚綅鍚岖О
		Position dto = iPost.getPositionById(2473);
		
		System.out.println(dto);
		
		System.out.println(dto.getPosName() + dto.getOrgId() + dto.getOrgName());
		
//		3686
		List<Position> list = iPost.getPossByUserId(3686);
		for(Position p : list) {
			System.out.println(p.getId());
		}
		
		
		MenuWebService menuService = context.getBean(MenuWebService.class);
		//3686
		List<Menu> menuList = menuService.getAllMenusByUserIdAndAppCode(4375, "A_DZGWXT");
		
		for(Menu m : menuList) {
			for(Menu child : m.getChildren()) {
				System.out.println(child.getMenuCode() + "\t" + child.getMenuName() + "\t" + child.getId()) ;
				if(child.getChildren() != null) {
					for(Menu cc : child.getChildren()) {
						System.out.println(cc.getMenuCode() + "\t" + cc.getMenuName() + "\t" + cc.getId()) ;
					}
				}
			}
		}
		
	}
}