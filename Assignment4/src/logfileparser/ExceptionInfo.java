package logfileparser;

import java.io.Serializable;

/**
 * A POJO class to store all the info regarding an exception.
 * @author amans
 *
 */
public class ExceptionInfo{
	private String exceptionMessage;
	private String codeLineNum;
	private String className;
	private String methodName;
	private String desc;
	private String logTrace;
	
	public ExceptionInfo() {
		super();
	}

	public ExceptionInfo(String exceptionMessage, String codeLineNum, String className, String methodName, String desc,
			String logTrace) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.codeLineNum = codeLineNum;
		this.className = className;
		this.methodName = methodName;
		this.desc = desc;
		this.logTrace = logTrace;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getCodeLineNum() {
		return codeLineNum;
	}

	public void setCodeLineNum(String codeLineNum) {
		this.codeLineNum = codeLineNum;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLogTrace() {
		return logTrace;
	}

	public void setLogTrace(String logTrace) {
		this.logTrace = logTrace;
	}

	@Override
	public String toString() {
		return "ExceptionInfo\n\nexceptionMessage = " + exceptionMessage + "\ncodeLineNum = " + codeLineNum + "\nclassName = "
				+ className + "\nmethodName = " + methodName + "\ndesc = " + desc + "\nlogTrace = \n" + logTrace + "\n";
	}
}
