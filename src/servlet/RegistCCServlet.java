package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

//import utils.xmlHandle.CreateDocument;
//import utils.xmlHandle.SendXml;
/**
 * 这是处理注册页面信息的类
 *-------------------------------------- 
 * 							/\_/\
 * @作者--->  LiangZhan    =( ^w^ )=                            
 *                          )   (  //
 *                         (__ __)//
 * @日期---> 2017-7-19
 *--------------------------------------
 */
public class RegistCCServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		// 设置传递和接收的字符编码参数
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String clientNumber = request.getParameter("clientNumber");
		String clientPaper = request.getParameter("clientPaper");
		String paperNumber = request.getParameter("paperNumber");

		String paperStates = request.getParameter("paperStates");
		String sex = request.getParameter("sex");

		String clientKinds = request.getParameter("clientKinds");
		String Kinds = request.getParameter("Kinds");
		String chineseName = request.getParameter("chineseName");

		String englishName = request.getParameter("englishName");
		String phoneNumber = request.getParameter("phoneNumber");
		String States = request.getParameter("States");

		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String mail = request.getParameter("mail");

		String address = request.getParameter("address");
		String addressNumber = request.getParameter("addressNumber");
		String callPhone = request.getParameter("callPhone");
		String clientNick = request.getParameter("clientNick");

		// 打印数据
		System.out.println("clientNumber=" + clientNumber + "/" + "clientPaper"
				+ clientPaper + "/" + "paperNumber" + paperNumber);
		System.out.println("paperStates=" + paperStates + "/" + "sex" + sex);
		System.out.println("clientKinds=" + clientKinds + "/" + "Kinds" + Kinds
				+ "/" + "chineseName" + chineseName);
		System.out.println("englishName=" + englishName + "/" + "phoneNumber"
				+ phoneNumber + "/" + "States" + States);
		System.out.println("province=" + province + "/" + "city" + city + "/"
				+ "mail" + mail);
		System.out.println("address=" + address + "/" + "addressNumber"
				+ addressNumber + "/" + "callPhone" + callPhone);
		System.out.println("clientNick=" + clientNick);
		
//		// 这里把信息进行打包成xml文件，发送到esb
//		Document document = CreateDocument.getDocument();
//		// 设置根节点
//		Element root = document.createElement("clientMessage");
//		document.appendChild(root);
//
//		Element client = document.createElement("client");
//		root.appendChild(client);
//
//		Element cNumber = document.createElement("clientNumber");
//		cNumber.setTextContent(clientNumber);
//
//		Element cPaper = document.createElement("clientPaper");
//		cPaper.setTextContent(clientPaper);
//		//打印节点值，看是否正常
//		System.out.println("cPaper.getTextContent="+cPaper.getTextContent());
//
//		Element pNumber = document.createElement("paperNumber");
//		pNumber.setTextContent(paperNumber);
//
//		Element pStates = document.createElement("paperStates");
//		pStates.setTextContent(paperStates);
//
//		Element sex1 = document.createElement("sex");
//		sex1.setTextContent(sex);
//
//		Element cKinds = document.createElement("clientKinds");
//		cKinds.setTextContent(clientKinds);
//
//		Element Kinds1 = document.createElement("Kinds");
//		Kinds1.setTextContent(Kinds);
//
//		Element cName = document.createElement("chineseName");
//		cName.setTextContent(chineseName);
//
//		Element eName = document.createElement("englishName");
//		eName.setTextContent(englishName);
//
//		Element phoneNumber1 = document.createElement("phoneNumber");
//		phoneNumber1.setTextContent(phoneNumber);
//
//		Element States1 = document.createElement("States");
//		States1.setTextContent(States);
//
//		Element province1 = document.createElement("province");
//		province1.setTextContent(province);
//
//		Element city1 = document.createElement("city");
//		city1.setTextContent(city);
//
//		Element mail1 = document.createElement("mail");
//		mail1.setTextContent(mail);
//
//		Element address1 = document.createElement("address");
//		address1.setTextContent(address);
//
//		Element aNumber = document.createElement("addressNumber");
//		aNumber.setTextContent(addressNumber);
//
//		Element cPhone = document.createElement("callPhone");
//		cPhone.setTextContent(callPhone);
//
//		Element cNick = document.createElement("clientNick");
//		cNick.setTextContent(clientNick);
//
//		client.appendChild(cNumber);
//		client.appendChild(cPaper);
//		client.appendChild(pNumber);
//		client.appendChild(pStates);
//		client.appendChild(sex1);
//		client.appendChild(cKinds);
//		client.appendChild(Kinds1);
//		client.appendChild(cName);
//		client.appendChild(eName);
//		client.appendChild(phoneNumber1);
//		client.appendChild(States1);
//		client.appendChild(province1);
//		client.appendChild(city1);
//		client.appendChild(mail1);
//		client.appendChild(address1);
//		client.appendChild(aNumber);
//		client.appendChild(cPhone);
//		client.appendChild(cNick);
//
//
//		//采用自定义的xmlToString方法把xml数据转换成string再调用resultToTeller发送数据和获得返回 消息
//		SendXml sendXml = new SendXml();
//		String message = sendXml.xmlToString(document);
//		//ESB返回的结果
//		String result = sendXml.sendAndGetResult(message);
//
//		System.out.println("ESB返回的结果"+result);
//		// 用于在前端界面输出成功与否的信息
//		PrintWriter out = response.getWriter();
//
//		if (result.equals("1")) {
//			out.println("客户注册成功！");
//		} else {
//			out.println("客户注册失败！");
//		}
		
	}	
}
