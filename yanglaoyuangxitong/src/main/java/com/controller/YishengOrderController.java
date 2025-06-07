
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
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
 * 商品订单
 * 后端接口
 *
 * @author
 * @email
 */
@RestController
@Controller
@RequestMapping("/yishengOrder")
public class YishengOrderController {
    private static final Logger logger = LoggerFactory.getLogger(YishengOrderController.class);

    private static final String TABLE_NAME = "yishengOrder";

    @Autowired
    private YishengOrderService yishengOrderService;


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
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request) {
        logger.debug("page方法:,,Controller:{},,params:{}", this.getClass().getName(), JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if (false)
            return R.error(511, "永不会进入");
        else if ("用户".equals(role))
            params.put("yonghuId", request.getSession().getAttribute("userId"));
        else if ("医生".equals(role))
            params.put("yishengId", request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = yishengOrderService.queryPage(params);

        //字典表数据转换
        List<YishengOrderView> list = (List<YishengOrderView>) page.getList();
        for (YishengOrderView c : list) {
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request) {
        logger.debug("info方法:,,Controller:{},,id:{}", this.getClass().getName(), id);
        YishengOrderEntity yishengOrder = yishengOrderService.selectById(id);
        if (yishengOrder != null) {
            //entity转view
            YishengOrderView view = new YishengOrderView();
            BeanUtils.copyProperties(yishengOrder, view);//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yishengOrder.getYonghuId());
            if (yonghu != null) {
                BeanUtils.copyProperties(yonghu, view, new String[]{"id", "createTime", "insertTime", "updateTime", "yishengId"
                        , "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
                view.setYonghuId(yonghu.getId());
            }
            //级联表 医生
            //级联表
            YishengEntity yisheng = yishengService.selectById(yishengOrder.getYishengId());
            if (yisheng != null) {
                BeanUtils.copyProperties(yisheng, view, new String[]{"id", "createTime", "insertTime", "updateTime", "yishengId"
                        , "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
                view.setYishengId(yisheng.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        } else {
            return R.error(511, "查不到数据");
        }

    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YishengOrderEntity yishengOrder, HttpServletRequest request) {
        logger.debug("save方法:,,Controller:{},,yishengOrder:{}", this.getClass().getName(), yishengOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if (false)
            return R.error(511, "永远不会进入");
        else if ("医生".equals(role))
            yishengOrder.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if ("用户".equals(role))
            yishengOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        yishengOrder.setCreateTime(new Date());
        yishengOrder.setInsertTime(new Date());
        yishengOrderService.insert(yishengOrder);

        return R.ok();
    }

    /**
     * 后端修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody YishengOrderEntity yishengOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yishengOrder:{}", this.getClass().getName(), yishengOrder.toString());
        YishengOrderEntity oldYishengOrderEntity = yishengOrderService.selectById(yishengOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("医生".equals(role))
//            yishengOrder.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("用户".equals(role))
//            yishengOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        yishengOrderService.updateById(yishengOrder);//根据id更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request) {
        logger.debug("delete:,,Controller:{},,ids:{}", this.getClass().getName(), ids.toString());
        List<YishengOrderEntity> oldYishengOrderList = yishengOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yishengOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName, HttpServletRequest request) {
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}", this.getClass().getName(), fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YishengOrderEntity> yishengOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields = new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if (lastIndexOf == -1) {
                return R.error(511, "该文件没有后缀");
            } else {
                String suffix = fileName.substring(lastIndexOf);
                if (!".xls".equals(suffix)) {
                    return R.error(511, "只支持后缀为xls的excel文件");
                } else {
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if (!file.exists()) {
                        return R.error(511, "找不到上传文件，请联系管理员");
                    } else {
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for (List<String> data : dataList) {
                            //循环
                            YishengOrderEntity yishengOrderEntity = new YishengOrderEntity();
//                            yishengOrderEntity.setYishengOrderUuidNumber(data.get(0));                    //编号 要改的
//                            yishengOrderEntity.setYishengId(Integer.valueOf(data.get(0)));   //医生 要改的
//                            yishengOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yishengOrderEntity.setYishengOrderTime(sdf.parse(data.get(0)));          //挂号日期 要改的
//                            yishengOrderEntity.setShijianduanTypes(Integer.valueOf(data.get(0)));   //挂号时间段 要改的
//                            yishengOrderEntity.setYishengOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            yishengOrderEntity.setYishengOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            yishengOrderEntity.setInsertTime(date);//时间
//                            yishengOrderEntity.setCreateTime(date);//时间
                            yishengOrderList.add(yishengOrderEntity);


                            //把要查询是否重复的字段放入map中
                            //编号
                            if (seachFields.containsKey("yishengOrderUuidNumber")) {
                                List<String> yishengOrderUuidNumber = seachFields.get("yishengOrderUuidNumber");
                                yishengOrderUuidNumber.add(data.get(0));//要改的
                            } else {
                                List<String> yishengOrderUuidNumber = new ArrayList<>();
                                yishengOrderUuidNumber.add(data.get(0));//要改的
                                seachFields.put("yishengOrderUuidNumber", yishengOrderUuidNumber);
                            }
                        }

                        //查询是否重复
                        //编号
                        List<YishengOrderEntity> yishengOrderEntities_yishengOrderUuidNumber = yishengOrderService.selectList(new EntityWrapper<YishengOrderEntity>().in("yisheng_order_uuid_number", seachFields.get("yishengOrderUuidNumber")));
                        if (yishengOrderEntities_yishengOrderUuidNumber.size() > 0) {
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for (YishengOrderEntity s : yishengOrderEntities_yishengOrderUuidNumber) {
                                repeatFields.add(s.getYishengOrderUuidNumber());
                            }
                            return R.error(511, "数据库的该表中的 [编号] 字段已经存在 存在数据为:" + repeatFields.toString());
                        }
                        yishengOrderService.insertBatch(yishengOrderList);
                        return R.ok();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(511, "批量插入数据异常，请联系管理员");
        }
    }


    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request) {
        logger.debug("list方法:,,Controller:{},,params:{}", this.getClass().getName(), JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yishengOrderService.queryPage(params);

        //字典表数据转换
        List<YishengOrderView> list = (List<YishengOrderView>) page.getList();
        for (YishengOrderView c : list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request) {
        logger.debug("detail方法:,,Controller:{},,id:{}", this.getClass().getName(), id);
        YishengOrderEntity yishengOrder = yishengOrderService.selectById(id);
        if (yishengOrder != null) {


            //entity转view
            YishengOrderView view = new YishengOrderView();
            BeanUtils.copyProperties(yishengOrder, view);//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yishengOrder.getYonghuId());
            if (yonghu != null) {
                BeanUtils.copyProperties(yonghu, view, new String[]{"id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //级联表
            YishengEntity yisheng = yishengService.selectById(yishengOrder.getYishengId());
            if (yisheng != null) {
                BeanUtils.copyProperties(yisheng, view, new String[]{"id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYishengId(yisheng.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        } else {
            return R.error(511, "查不到数据");
        }
    }


    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YishengOrderEntity yishengOrder, HttpServletRequest request) {
        logger.debug("add方法:,,Controller:{},,yishengOrder:{}", this.getClass().getName(), yishengOrder.toString());
        YishengEntity yishengEntity = yishengService.selectById(yishengOrder.getYishengId());
        if (yishengEntity == null) {
            return R.error(511, "查不到该医生");
        }
        // Double yishengNewMoney = yishengEntity.getYishengNewmoney();

        if (false) {
        }

        //计算所获得积分
        Double buyJifen = 0.0;
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);
        if (yonghuEntity == null)
            return R.error(511, "用户不能为空");
        if (yonghuEntity.getNewMoney() == null)
            return R.error(511, "用户金额不能为空");
        double balance = yonghuEntity.getNewMoney() - yishengEntity.getYishengNewmoney() * 1;//余额
        if (balance < 0)
            return R.error(511, "余额不够支付");
        yishengOrder.setYishengOrderTypes(101); //设置订单状态为已挂号
        yishengOrder.setYishengOrderTruePrice(yishengEntity.getYishengNewmoney() * 1); //设置实付价格
        yishengOrder.setYonghuId(userId); //设置订单支付人id
        yishengOrder.setYishengOrderUuidNumber(String.valueOf(new Date().getTime()));
        yishengOrder.setInsertTime(new Date());
        yishengOrder.setCreateTime(new Date());
        yishengOrderService.insert(yishengOrder);//新增订单
        //更新第一注册表
        yonghuEntity.setNewMoney(balance);//设置金额
        yonghuService.updateById(yonghuEntity);


        return R.ok();
    }

    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request) throws ParseException {
        logger.debug("order方法:,,Controller:{},,params:{}", this.getClass().getName(), params.toString());
        String yishengOrderUuidNumber = String.valueOf(new Date().getTime());

        String data = String.valueOf(params.get("yishengs"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> yishengs = JSON.parseObject(jsonArray.toString(), List.class);

        YishengEntity yisheng111 = yishengService.selectById(Integer.valueOf(String.valueOf(yishengs.get(0).get("getyishengId"))));//购买的商品
        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        Integer shijianduanTypes = Integer.valueOf(String.valueOf(params.get("shijianduanTypes")));//挂号时间段
        String yishengOrderTime = String.valueOf(params.get("yishengOrderTime"));//商品id


        Wrapper<YishengOrderEntity> queryWrapper = new EntityWrapper<YishengOrderEntity>()
                .eq("shijianduan_types", shijianduanTypes)
                .or()
                .eq("yisheng_order_time",new SimpleDateFormat("yyyy-MM-dd").parse(yishengOrderTime))
                ;
        List<YishengOrderEntity> yishengOrderEntities = yishengOrderService.selectList(queryWrapper);
        if(yishengOrderEntities.size()>yisheng111.getYishengNumber()){
            return R.error("当前时间段已挂号（"+yisheng111.getYishengNumber()+"）人，请选择其时间段挂号");
        }

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<YishengOrderEntity> yishengOrderList = new ArrayList<>();
        //商品表
        List<YishengEntity> yishengList = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : yishengs) {
            //取值
            Integer yishengId = Integer.valueOf(String.valueOf(map.get("yishengId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            YishengEntity yishengEntity = yishengService.selectById(yishengId);//购买的商品
            String id = String.valueOf(map.get("id"));

            //订单信息表增加数据
            YishengOrderEntity yishengOrderEntity = new YishengOrderEntity<>();

            //赋值订单信息
            yishengOrderEntity.setYishengOrderUuidNumber(yishengOrderUuidNumber);//编号
            yishengOrderEntity.setYishengId(yishengId);//医生  ???????
            yishengOrderEntity.setYonghuId(userId);//用户
            yishengOrderEntity.setYishengOrderTime(new SimpleDateFormat("yyyy-MM-dd").parse(yishengOrderTime));//挂号日期 ？？？？？？
            yishengOrderEntity.setShijianduanTypes(shijianduanTypes);//挂号时间段 ？？？？？？
            yishengOrderEntity.setYishengOrderTypes(101);//订单类型
            yishengOrderEntity.setInsertTime(new Date());//订单创建时间
            yishengOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
            //计算金额
            Double money = new BigDecimal(yishengEntity.getYishengNewmoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

            if (yonghuEntity.getNewMoney() - money < 0) {
                return R.error("余额不足,请充值！！！");
            } else {
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额


                yishengOrderEntity.setYishengOrderTruePrice(money);

            }
            yishengOrderList.add(yishengOrderEntity);
            yishengList.add(yishengEntity);

        }
        yishengOrderService.insertBatch(yishengOrderList);
        yishengService.updateBatchById(yishengList);
        yonghuService.updateById(yonghuEntity);

        return R.ok();
    }


    /**
     * 取消
     */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request) {
        logger.debug("refund方法:,,Controller:{},,id:{}", this.getClass().getName(), id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

        YishengOrderEntity yishengOrder = yishengOrderService.selectById(id);//当前表service
        Integer yishengId = yishengOrder.getYishengId();
        if (yishengId == null)
            return R.error(511, "查不到该医生");
        YishengEntity yishengEntity = yishengService.selectById(yishengId);
        if (yishengEntity == null)
            return R.error(511, "查不到该医生");

        Integer userId = (Integer) request.getSession().getAttribute("userId");
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);
        if (yonghuEntity == null)
            return R.error(511, "用户不能为空");
        if (yonghuEntity.getNewMoney() == null)
            return R.error(511, "用户金额不能为空");
        Double zhekou = 1.0;

        //计算金额
        Double money = yishengEntity.getYishengNewmoney() * 1 * zhekou;
        //计算所获得积分
        Double buyJifen = 0.0;
        yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


        yishengOrder.setYishengOrderTypes(102);//设置订单状态为已取消
        yishengOrderService.updateById(yishengOrder);//根据id更新
        yonghuService.updateById(yonghuEntity);//更新用户信息
        yishengService.updateById(yishengEntity);//更新订单中医生的信息

        return R.ok();
    }

    /**
     * 完成
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id, HttpServletRequest request) {
        logger.debug("refund:,,Controller:{},,ids:{}", this.getClass().getName(), id.toString());
        YishengOrderEntity yishengOrderEntity = yishengOrderService.selectById(id);
        yishengOrderEntity.setYishengOrderTypes(103);//设置订单状态为已完成
        yishengOrderService.updateById(yishengOrderEntity);

        return R.ok();
    }


}

