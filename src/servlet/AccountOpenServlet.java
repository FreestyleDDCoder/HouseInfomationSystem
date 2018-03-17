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
 * 这是账户开户页面处理的Servlet
 *-------------------------------------- 
 * 							/\_/\
 * @作者--->  LiangZhan    =( ^w^ )=                            
 *                          )   (  //
 *                         (__ __)//
 * @日期---> 2017-7-23
 *--------------------------------------
 */
public class AccountOpenServlet extends HttpServlet {
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

		String clientNumberAO = request.getParameter("clientNumberAO");
		String clientManagerNumber = request
				.getParameter("clientManagerNumber");
		String clientKindsAO = request.getParameter("clientKindsAO");
		String moneyKinds = request.getParameter("moneyKinds");
		String balanceKinds = request.getParameter("balanceKinds");
		String openTime = request.getParameter("openTime");
		String depositKindsAO = request.getParameter("depositKindsAO");

		// 这里进行客户编号校验，查看是否有该用户存在

		System.out.println("clientNumberAO=" + clientNumberAO
				+ "clientManagerNumber=" + clientManagerNumber
				+ "clientKindsAO=" + clientKindsAO + "moneyKinds=" + moneyKinds
				+ "balanceKinds=" + balanceKinds + "openTime=" + openTime
				+ "depositKindsAO=" + depositKindsAO);
//		// 封装成xml文件
//		// 这里把信息进行打包成xml文件，发送到esb
//		Document document = CreateDocument.getDocument();
//		// 设置根节点
//		Element root = document.createElement("accountOpenMessage");
//		document.appendChild(root);
//
//		Element account = document.createElement("account");
//		root.appendChild(account);
//
//		Element cNumberAO = document.createElement("clientNumberAO");
//		cNumberAO.setTextContent(clientNumberAO);
//
//		Element cManagerNumber = document.createElement("clientManagerNumber");
//		cManagerNumber.setTextContent(clientManagerNumber);
//
//		Element cKindsAO = document.createElement("clientKindsAO");
//		cKindsAO.setTextContent(clientKindsAO);
//
//		Element mKinds = document.createElement("moneyKinds");
//		mKinds.setTextContent(moneyKinds);
//
//		Element bKinds = document.createElement("balanceKinds");
//		bKinds.setTextContent(balanceKinds);
//
//		Element oTime = document.createElement("openTime");
//		oTime.setTextContent(openTime);
//
//		Element dKindsAO = document.createElement("depositKindsAO");
//		dKindsAO.setTextContent(depositKindsAO);
//
//		account.appendChild(cNumberAO);
//		account.appendChild(cManagerNumber);
//		account.appendChild(cKindsAO);
//		account.appendChild(mKinds);
//		account.appendChild(bKinds);
//		account.appendChild(oTime);
//		account.appendChild(dKindsAO);
//
//		SendXml sendXml = new SendXml();
//		String message = sendXml.xmlToString(document);
//		String result = sendXml.sendAndGetResult(message);
//		// 下面处理result
//		PrintWriter out = response.getWriter();
//		out.println(result);
//		out.flush();
//		out.close();

	}

}
