<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <div class="vernav2 iconmenu">
    	<ul>
        	<li><a href="#formsub" class="editor">新闻分类管理</a>
            	<span class="arrow"></span>
            	<ul id="formsub">
                    <li><a href="<%=path%>/NewsCategoryController?act=show_insert_page">新闻分类添加</a></li>
                    <li><a href="<%=path%>/NewsCategoryController?act=show_list_page">新闻分类管理</a></li>
                </ul>
            </li>
           <li><a href="#error" class="editor">新闻内容管理</a>
            	<span class="arrow"></span>
            	<ul id="error">
                    <li><a href="#">新闻内容添加</a></li>
                    <li><a href="#">新闻内容管理</a></li>
                </ul>
            </li>
        </ul>
        <a class="togglemenu"></a>
        <br /><br />
    </div><!--leftmenu-->
        
    