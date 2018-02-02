package com.haoa193.springbootdemo.entity.usr;

import io.gd.generator.annotation.Field;
import io.gd.generator.annotation.Type;
import io.gd.generator.annotation.query.Query;
import io.gd.generator.annotation.query.QueryModel;
import io.gd.generator.annotation.view.View;
import io.gd.generator.annotation.view.ViewObject;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

import static com.haoa193.springbootdemo.entity.usr.UserLog.VO_LIST;
import static io.gd.generator.api.query.Predicate.EQ;

@Entity
@Table(name = "usr_user_log")
@Getter
@Setter
@Type(label = "用户日志")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@QueryModel
@ViewObject(groups = {VO_LIST}, views = {})
public class UserLog implements Serializable {

	public static final String VO_LIST = "UserLogListVo";

	@Id
	@Field(label = "id")
	@NotBlank
	@View
	@Column(columnDefinition = "BigInt(20)")
	private String id;

	@NotBlank
	@Field(label = "用户id")
	@Query({EQ})
	@View
	@Column(columnDefinition = "BigInt(20)")
	private String userId;

	@Query({EQ})
	@Field(label = "项目id")
	@NotBlank
	@View
	@Column(columnDefinition = "BigInt(20)")
	private String projectId;

	@NotBlank
	@Field(label = "操作",description = "增加，删除等")
	@View
	private String operation;

	@NotBlank
	@Field(label = "操作者id")
	@Column(columnDefinition = "BigInt(20)")
	@View
	private String operatorId;

	@NotNull
	@Field(label = "操作时间")
	@View
	private Date operatedTime;

	@Column(length = 1000)
	@Field(label = "备注")
	@View
	private String remark;

}
