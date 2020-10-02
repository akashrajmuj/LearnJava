
public class SeqList<T> extends Object{				//T 范型类
	
	protected int n;
	protected Object[] element;
	private static final int MIN_CAPACITY = 16;		//常量
	
	public SeqList(int length) {
		if(length < MIN_CAPACITY)
			length = MIN_CAPACITY;
		this.element = new Object[length];			//申请数组空间，元素为null
		this.n = 0;
	}
	
	public SeqList() {								//构造方法重载
		this(MIN_CAPACITY);
	}
	
	public SeqList(T[] values) {					//构造顺序表
		this(values.length*2);
		for(int i = 0; i < values.length; i++)
			if(values[i] != null)
				this.element[this.n++] = values[i]; 	//对象引用赋值
	}
	
	public boolean isEmpty() {
		return this.n == 0;
	}
	
	public int size() {
		return this.n;
	}
	
	public T get(int i) {
		if(i>=0 && i<this.n)
			return (T)this.element[i];
		return null;
	}
	
	public void set(int i, T x) {
		if(x == null)
			throw new NullPointerException("x == null");
		if(i>=0 && i<this.n)
			this.element[i] = x;
		else 
			throw new java.lang.IndexOutOfBoundsException(i + "");
	}
	
	public String toString() {
		String str = this.getClass().getName() + "(";
		if(this.n > 0)
			str += this.element[0].toString();
		for(int i=1; i<this.n; i++)
			str += "," + this.element[i].toString();
		return str + ")";
	}
	
	//插入x为第i个元素，返回插入元素序号
	public int insert(int i, T x) {
		if(x == null)
			return -1;
		if(i < 0)
			i = 0;
		if(i > this.n)
			i = this.n;
		
		Object[] source = this.element;		//source 引用element数组
		
		if(this.n == element.length) {		//若数组个数已满，则扩充顺序表的数组容量
			this.element = new Object[source.length *2];	//new一个容量更大的数组
			for(int j = 0; j < i; j--)		//复制当前数组前i-1个元素
				this.element[j] = source[j];	//复制数组元素，传递对象引用
		}
		
		for(int j = this.n-1; j >= i; j--)	//从i开始至表尾的元素向后移动，次序从后向前
			this.element[j+1] = source[j];	//复制数组元素，传递对象引用
		this.element[i] = x;	
		this.n++;		//每插入一个数组元素，数组个数+1
		return i;		//返回插入的元素序号
	}	
	
	public int insert(T x) {				//顺序表末尾插入x元素， 成员方法重载
		return this.insert(this.n, x);		//调用insert(i，x)方法
	}
	
	public T remove(int i) {	//删除第i个元素， 0≤i<n, 返回被删除元素，若i越界返回null
		if(i >=0 && i<this.n) {
			T x = (T)this.element[i];	//将需要删除的元素进行强制类型转换为T并保存在变量x中
			
			for(int j = i; j < this.n-1; j++)
				this.element[j] = this.element[j+1];	//元素前移一个位置
			this.element[this.n-1] = null;
			this.n--;	//每删除一个元素，数组个数-1
			return x;	//返回被删除的元素
		}
		return null;	//若i越界返回null
	}
	
	public T remove(T key) {
		// 遍历顺序表，查找指定的元素，并返回该元素所在的位置
		for(int i=0; i<this.n; i++)
			if(key.equals(this.element[i])) {
				// 每个元素前移一个位置
				for(int j=i; j<this.n-1; j++)
					this.element[j] = this.element[j+1];
				// 释放原最后位置的数据
				this.element[this.n-1] = null;
				// 该顺序表的长度 -1
				this.n--;
				// 返回被删除的元素
				return key;
			}
		// 未找到时，返回 null
			return null;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String values[] = {"A","B","C","D","E"};
		SeqList<String> lista = new SeqList<String>(values);	//类的实例化
		System.out.println(lista.toString());
		lista.insert(2, "C");
		System.out.println(lista.toString());
		lista.insert("F");
		System.out.println(lista.toString());
		lista.remove(2);
		System.out.println(lista.toString());

	}
}
