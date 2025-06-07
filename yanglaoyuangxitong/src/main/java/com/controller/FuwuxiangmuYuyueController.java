
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 服务项目预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fuwuxiangmuYuyue")
public class FuwuxiangmuYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(FuwuxiangmuYuyueController.class);

    private static final String TABLE_NAME = "fuwuxiangmuYuyue";

    @Autowired
    private FuwuxiangmuYuyueService fuwuxiangmuYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private FuwuxiangmuService fuwuxiangmuService;//服务项目
    @Autowired
    private MeishiService meishiService;//餐食目录
    @Autowired
    private NewsService newsService;//公告资讯
    @Autowired
    private YishengService yishengService;//医生
    @Autowired
    private YishengOrderService yishengOrderService;//商品订单
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = fuwuxiangmuYuyueService.queryPage(params);

        //字典表数据转换
        List<FuwuxiangmuYuyueView> list =(List<FuwuxiangmuYuyueView>)page.getList();
        for(FuwuxiangmuYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FuwuxiangmuYuyueEntity fuwuxiangmuYuyue = fuwuxiangmuYuyueService.selectById(id);
        if(fuwuxiangmuYuyue !=null){
            //entity转view
            FuwuxiangmuYuyueView view = new FuwuxiangmuYuyueView();
            BeanUtils.copyProperties( fuwuxiangmuYuyue , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(fuwuxiangmuYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 服务项目
            //级联表
            FuwuxiangmuEntity fuwuxiangmu = fuwuxiangmuService.selectById(fuwuxiangmuYuyue.getFuwuxiangmuId());
            if(fuwuxiangmu != null){
            BeanUtils.copyProperties( fuwuxiangmu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setFuwuxiangmuId(fuwuxiangmu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FuwuxiangmuYuyueEntity fuwuxiangmuYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fuwuxiangmuYuyue:{}",this.getClass().getName(),fuwuxiangmuYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            fuwuxiangmuYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<FuwuxiangmuYuyueEntity> queryWrapper = new EntityWrapper<FuwuxiangmuYuyueEntity>()
            .eq("fuwuxiangmu_id", fuwuxiangmuYuyue.getFuwuxiangmuId())
            .eq("yonghu_id", fuwuxiangmuYuyue.getYonghuId())
            .in("fuwuxiangmu_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FuwuxiangmuYuyueEntity fuwuxiangmuYuyueEntity = fuwuxiangmuYuyueService.selectOne(queryWrapper);
        if(fuwuxiangmuYuyueEntity==null){
            fuwuxiangmuYuyue.setFuwuxiangmuYuyueYesnoTypes(1);
            fuwuxiangmuYuyue.setInsertTime(new Date());
            fuwuxiangmuYuyue.setCreateTime(new Date());
            fuwuxiangmuYuyueService.insert(fuwuxiangmuYuyue);
            return R.ok();
        }else {
            if(fuwuxiangmuYuyueEntity.getFuwuxiangmuYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(fuwuxiangmuYuyueEntity.getFuwuxiangmuYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FuwuxiangmuYuyueEntity fuwuxiangmuYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,fuwuxiangmuYuyue:{}",this.getClass().getName(),fuwuxiangmuYuyue.toString());
        FuwuxiangmuYuyueEntity oldFuwuxiangmuYuyueEntity = fuwuxiangmuYuyueService.selectById(fuwuxiangmuYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            fuwuxiangmuYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            fuwuxiangmuYuyueService.updateById(fuwuxiangmuYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody FuwuxiangmuYuyueEntity fuwuxiangmuYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,fuwuxiangmuYuyueEntity:{}",this.getClass().getName(),fuwuxiangmuYuyueEntity.toString());

        FuwuxiangmuYuyueEntity oldFuwuxiangmuYuyue = fuwuxiangmuYuyueService.selectById(fuwuxiangmuYuyueEntity.getId());//查询原先数据

//        if(fuwuxiangmuYuyueEntity.getFuwuxiangmuYuyueYesnoTypes() == 2){//通过
//            fuwuxiangmuYuyueEntity.setFuwuxiangmuYuyueTypes();
//        }else if(fuwuxiangmuYuyueEntity.getFuwuxiangmuYuyueYesnoTypes() == 3){//拒绝
//            fuwuxiangmuYuyueEntity.setFuwuxiangmuYuyueTypes();
//        }
        fuwuxiangmuYuyueEntity.setFuwuxiangmuYuyueShenheTime(new Date());//审核时间
        fuwuxiangmuYuyueService.updateById(fuwuxiangmuYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<FuwuxiangmuYuyueEntity> oldFuwuxiangmuYuyueList =fuwuxiangmuYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        fuwuxiangmuYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FuwuxiangmuYuyueEntity> fuwuxiangmuYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FuwuxiangmuYuyueEntity fuwuxiangmuYuyueEntity = new FuwuxiangmuYuyueEntity();
//                            fuwuxiangmuYuyueEntity.setFuwuxiangmuId(Integer.valueOf(data.get(0)));   //服务项目 要改的
//                            fuwuxiangmuYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            fuwuxiangmuYuyueEntity.setFuwuxiangmuYuyueTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            fuwuxiangmuYuyueEntity.setFuwuxiangmuYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            fuwuxiangmuYuyueEntity.setFuwuxiangmuYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            fuwuxiangmuYuyueEntity.setFuwuxiangmuYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            fuwuxiangmuYuyueEntity.setInsertTime(date);//时间
//                            fuwuxiangmuYuyueEntity.setCreateTime(date);//时间
                            fuwuxiangmuYuyueList.add(fuwuxiangmuYuyueEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        fuwuxiangmuYuyueService.insertBatch(fuwuxiangmuYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = fuwuxiangmuYuyueService.queryPage(params);

        //字典表数据转换
        List<FuwuxiangmuYuyueView> list =(List<FuwuxiangmuYuyueView>)page.getList();
        for(FuwuxiangmuYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FuwuxiangmuYuyueEntity fuwuxiangmuYuyue = fuwuxiangmuYuyueService.selectById(id);
            if(fuwuxiangmuYuyue !=null){


                //entity转view
                FuwuxiangmuYuyueView view = new FuwuxiangmuYuyueView();
                BeanUtils.copyProperties( fuwuxiangmuYuyue , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(fuwuxiangmuYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    FuwuxiangmuEntity fuwuxiangmu = fuwuxiangmuService.selectById(fuwuxiangmuYuyue.getFuwuxiangmuId());
                if(fuwuxiangmu != null){
                    BeanUtils.copyProperties( fuwuxiangmu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFuwuxiangmuId(fuwuxiangmu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FuwuxiangmuYuyueEntity fuwuxiangmuYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fuwuxiangmuYuyue:{}",this.getClass().getName(),fuwuxiangmuYuyue.toString());
        Wrapper<FuwuxiangmuYuyueEntity> queryWrapper = new EntityWrapper<FuwuxiangmuYuyueEntity>()
            .eq("fuwuxiangmu_id", fuwuxiangmuYuyue.getFuwuxiangmuId())
            .eq("yonghu_id", fuwuxiangmuYuyue.getYonghuId())
            .in("fuwuxiangmu_yuyue_yesno_types", new Integer[]{1,2})
            .eq("fuwuxiangmu_yuyue_yesno_text", fuwuxiangmuYuyue.getFuwuxiangmuYuyueYesnoText())
//            .notIn("fuwuxiangmu_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FuwuxiangmuYuyueEntity fuwuxiangmuYuyueEntity = fuwuxiangmuYuyueService.selectOne(queryWrapper);
        if(fuwuxiangmuYuyueEntity==null){
            fuwuxiangmuYuyue.setFuwuxiangmuYuyueYesnoTypes(1);
            fuwuxiangmuYuyue.setInsertTime(new Date());
            fuwuxiangmuYuyue.setCreateTime(new Date());
        fuwuxiangmuYuyueService.insert(fuwuxiangmuYuyue);

            return R.ok();
        }else {
            if(fuwuxiangmuYuyueEntity.getFuwuxiangmuYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(fuwuxiangmuYuyueEntity.getFuwuxiangmuYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

