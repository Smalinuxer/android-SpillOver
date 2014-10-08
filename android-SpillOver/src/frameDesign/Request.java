package frameDesign;

import java.util.Map;

public abstract class Request <T> implements Comparable<Request<T>> {
	
	public Request(String url){
		this.mUrl = url;
	}
	
	private enum Priority{
		LOW,
		MEDIUM,
		HIGH
	}
	
	public Priority getPriority(){
		return Priority.MEDIUM; 
	}
	
	public boolean shouldCache(){
		return true;
	}
	
	private String mUrl;
	
	public String getUrl(){
		return mUrl;
	}
	
	protected Map<String,String> headers;	//����ͷ
	
	protected Map<String,String> params;	//�������
	
	public abstract Map<String,String> getHeader();	//�ص�����ͷ
	
	public abstract Map<String,String> getParam(); 	//�ص������б�

	protected abstract T handlerCallBack();
	
	@Override
	public int compareTo(Request<T> another) {
		
		if(this.getPriority() == another.getPriority()){
			return 0;
		}
		
		return another.getPriority().ordinal() - this.getPriority().ordinal();
	}
	
	
}
