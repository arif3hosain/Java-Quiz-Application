

package model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Exam {
    Document document;
    public int currentQuestion=0;
    public Map selections=new LinkedHashMap();
    public ArrayList<QuizQuestion> questionList=new ArrayList<QuizQuestion>(10);

   public Exam(String test) throws SAXException,ParserConfigurationException,IOException, URISyntaxException{
		document=CreateDOM.getDOM();
                
	}
    
    	
		
	public void setQuestion(int i){
            int number=i;
            String options[]=new String[4];
	    String question=null;
	    int correct=0;
            
	    System.out.println("Dom "+document);
            NodeList qList=document.getElementsByTagName("question");
	    NodeList childList=qList.item(i).getChildNodes();
	    
	    int counter=0;
	    
	    for (int j = 0; j < childList.getLength(); j++) {
            Node childNode = childList.item(j);
            if ("answer".equals(childNode.getNodeName()))
            {
                options[counter]=childList.item(j).getTextContent();
                counter++;
            }
            else if("quizquestion".equals(childNode.getNodeName()))
            {
            	question=childList.item(j).getTextContent();
            }
            else if("correct".equals(childNode.getNodeName()))
            {
            	correct=Integer.parseInt(childList.item(j).getTextContent());
            }
            
        }   //finish loop
	    System.out.println("Retrieving Question Number "+number);
		System.out.println("Question is : "+question);
		for(String a:options)
		{
			System.out.println(a);
		}
		System.out.println("Correct answer index : "+correct);
		
		QuizQuestion q=new QuizQuestion();
		q.setQuestionNumber(number);
		q.setQuestion(question);
		q.setAnsIndex(correct);
		q.setOptions(options);
		questionList.add(number,q);
		
	}

    public int calculateResult(Exam exam) {
        int totalCorrect=0;
		Map<Integer,Integer> userSelectionsMap=exam.selections;		
		List<Integer> userSelectionsList=new ArrayList<Integer>(10);
		for (Map.Entry<Integer, Integer> entry :userSelectionsMap.entrySet()) {
			userSelectionsList.add(entry.getValue());
		}
		List<QuizQuestion> questionList=exam.questionList;
		List<Integer> correctAnswersList=new ArrayList<Integer>(10);
		for(QuizQuestion question: questionList){
			correctAnswersList.add(question.getAnsIndex());
		}
		
		for(int i=0;i<selections.size();i++){
			System.out.println(userSelectionsList.get(i)+" --- "+correctAnswersList.get(i));
			if((userSelectionsList.get(i)-1)==correctAnswersList.get(i)){
				totalCorrect++;
			}
		}
		      	
		return totalCorrect;
        
       
    }

    public int getCurrentQuestion() {
        return currentQuestion;
    }

    public Map<Integer, Integer> getSelections() {
        return selections;
    }

    public ArrayList<QuizQuestion> getQuestionList() {
        return questionList;
    }
    
    
}
