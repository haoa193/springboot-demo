package com.haoa193.springbootdemo.model.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.io.Serializable;
import java.util.stream.Collectors;

import io.gd.generator.meta.querymodel.OrderBy;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLogQueryModel implements Serializable {

	private String userIdEQ;

	private String projectIdEQ;

	private Integer pageNumber;

	private Integer pageSize;

	private List<OrderBy> orderByList=new ArrayList<OrderBy>();


	public void addOrderBy(OrderBy orderBy){
    	if(orderByList==null){
    		this.orderByList = new ArrayList<OrderBy>();
        }
		if(null==orderBy){
			return;
		}
		String orderByStr = orderBy.toString();
		if(null!=orderByStr||orderByStr.length()!=0){
			String orderByProp = orderByStr.split(" ")[0];
			if(!fieldNames.contains(orderByProp)){
				throw new IllegalArgumentException("field:"+orderByProp+" not found");
			}
			this.orderByList.add(orderBy);
		}
	}

	public Long getOffset() {
		if (pageNumber == null || pageSize == null) {
			return null;
		}
		return ((long) pageNumber - 1) * pageSize;
	}

    public String getOrderByAndDirection() {
        if (null==orderByList || orderByList.size()==0) {
            return null;
        }
        List<String> tranStrList = orderByList
                .stream()
                .map(item->{
                        String[] strArray = item.toString().split(" ");
                        return camelToUnderline(strArray[0])+" "+strArray[1];
                })
                .collect(Collectors.toList());
        return String.join(",",tranStrList);
    }

	private String camelToUnderline(String param) {
		if (param == null || "".equals(param.trim())) {
			return "";
		}
		int len = param.length();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			char c = param.charAt(i);
			if (Character.isUpperCase(c)) {
				sb.append("_");
				sb.append(Character.toLowerCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	private static Set<String> fieldNames = new HashSet<>();

	static {
		fieldNames.add("operatedTime");
		fieldNames.add("remark");
		fieldNames.add("id");
		fieldNames.add("userId");
		fieldNames.add("projectId");
		fieldNames.add("operation");
		fieldNames.add("operatorId");
	}

}