import com.sun.org.apache.bcel.internal.generic.LNEG
import groovy.xml.XmlUtil

recv = """P00000240[17217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217217]<?xmlversion="1.0"encoding="GBK"standalone="no"?><TRX><INFO><VERSION>01</VERSION><TRXCODE>0110</TRXCODE><TRXSEQ>20200101100000618055</TRXSEQ><TRXDATE>20200101</TRXDATE><TRXTIME>190005</TRXTIME><RESPCODE>0000</RESPCODE><RESPINFO>RESPINFO</RESPINFO></INFO><DATA><ACCTNO>44032301040010989</ACCTNO><CURRENCY>CNY</CURRENCY><BALANCE>8103970930</BALANCE></DATA></TRX>"""

xmlHeadLen = 49
headLen = 1 + 8 + 172 + xmlHeadLen
recv_xml = new String(recv.toCharArray(), headLen, recv.toCharArray().length-headLen)

println("recv_xml=[$recv_xml]")

//xml_parser = new XmlParser().parse()
//xml_parser = new XmlParser().parseText(recv_xml)


xml_parser = new XmlSlurper().parseText(recv_xml)

//println(xml_parser)
//println(xml_parser.INFO.VERSION.text())
//println(xml_parser.INFO.TRXCODE.text())

println(xml_parser."*".size())
// xml_parser 直接成为 XML 中的最顶层
println(xml_parser.INFO.TRXCODE)

