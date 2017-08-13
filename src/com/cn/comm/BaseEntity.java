package com.cn.comm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		/*调用了第三方包
		 * commons-beanutils.jar
		 * commons-lang.jar里面的类完成：
		 * toString()的重写
		 * */
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
