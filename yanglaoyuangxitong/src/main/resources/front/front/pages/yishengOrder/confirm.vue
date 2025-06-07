<template>
    <view class="content">
        <form>
            <view v-for="(item,index) in orderGoods " v-bind:key="index" class="cu-form-group">
                <image class="avator" :src="baseUrl+item.yishengPhoto" mode=""></image>
                <view class="title" style="width: 75%;">
                    <view style="margin-top: -50rpx;">{{item.yishengName}}</view>
                    <view >
                        x{{item.buyNumber}}
                        <text style="margin-left: 30upx;color: red;">￥{{item.yishengNewMoney}}</text>
                    </view>
                </view>
            </view>
			<view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
					class="title">挂号日期</view>
				<input
					:style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"var(--publicMainColor)","backgroundColor":"#fff","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderRadius":"0","borderWidth":"10rpx 2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
					v-model="yishengOrderTime" placeholder="挂号日期" :readonly="ro.yishengOrderTime"
					@tap="toggleTab('yishengOrderTime')"></input>
			</view>
			<view
				:style='{"boxShadow":"0","backgroundColor":"rgba(255, 255, 255, 0.25)","borderColor":"rgba(228, 232, 230, 1)","margin":"0 0 0px 0","borderWidth":"2rpx","borderStyle":"none none solid none ","height":"100rpx"}'
				class="cu-form-group">
				<view :style='{"width":"160rpx","fontSize":"28rpx","color":"var(--publicMainColor)","textAlign":"left"}'
					class="title">挂号时间段</view>
				<picker @change="shijianduanTypesChange" :value="shijianduanTypesIndex" :range="shijianduanTypesOptions"
					range-key="indexName">
					<view
						:style='{"padding":"0 30rpx","boxShadow":"0 0 0px rgba(0,0,0,.6) inset","margin":"0","borderColor":"var(--publicMainColor)","backgroundColor":"#fff","color":"rgba(0, 0, 0, 1)","textAlign":"left","borderRadius":"0","borderWidth":"10rpx 2rpx","fontSize":"28rpx","borderStyle":"solid","height":"88rpx","marginTop":"7rpx"}'
						class="uni-input">{{shijianduanTypes?shijianduanValue:"请选择挂号时间段"}}</view>
				</picker>
			</view>
            <view @tap="onAddressTap" class="cu-form-group">
                <view class="title">总价</view>
                <view>
                    <text v-if="yishengOrderPaymentTypes == 1">原价：￥{{(maxNewMouey).toFixed(2)}}</text>
                    <view v-if="yishengOrderPaymentTypes == 1"></view>
                    <text v-if="yishengOrderPaymentTypes == 1">折扣价：￥{{(maxNewMouey * zhekou).toFixed(2)}}</text>
                    <text v-if="yishengOrderPaymentTypes == 2">{{(maxNewMouey).toFixed(2)}}积分</text>
                </view>
            </view>
        </form>
        <view class="padding" style="text-align: center;">
            <button @tap="onSubmitTap()" class="bg-red lg">确认支付</button>
        </view>
		<w-picker mode="date" step="1" :current="false" :hasSecond="false" @confirm="yishengOrderTimeConfirm"
			ref="yishengOrderTime" themeColor="#333333"></w-picker>
    </view>
</template>

<script>
    export default {
        data() {
            return {
                user: {},//登录用户
                orderGoods: [],//展示数据
                maxNewMouey: 0,//总价格
                yishengOrderPaymentTypes:1,//是什么支付类型
                zhi:[
                    {
                        id:1,
                        val:"余额"
                    },
                    {
                        id:2,
                        val:"积分"
                    },
                ],
                zhekou:1,//折扣
				shijianduanTypesOptions: [],
				shijianduanTypesIndex: 0,
				shijianduanTypes:null,
				shijianduanValue:null,
				yishengOrderTime:null,
            }
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
        async onLoad(options) {
            // 获取订单信息，座位信息
            this.orderGoods = uni.getStorageSync('orderGoods');
            if(this.orderGoods.length>0){
                for (let i = 0; i < this.orderGoods.length; i++) {
                    this.maxNewMouey = this.maxNewMouey + parseFloat(this.orderGoods[i].yishengNewMoney) * this.orderGoods[i].buyNumber
                }
            }
			/*下拉框*/
			let shijianduanTypesParams = {
				page: 1,
				limit: 100,
				dicCode: 'shijianduan_types',
			}
			let shijianduanTypes = await this.$api.page(`dictionary`, shijianduanTypesParams);
			this.shijianduanTypesOptions = shijianduanTypes.data.list
			
            uni.removeStorageSync("orderGoods")
        },
		
        async onShow() {
            let _this = this
            let table = uni.getStorageSync("nowTable");
            let userRes = await _this.$api.session(table)
            _this.user = userRes.data

            let huiyuandengjiTypesRes = await _this.$api.page("dictionary",{
                dicCode: "huiyuandengji_types",
                dicName: "会员等级类型",
                codeIndexStart: _this.user.huiyuandengjiTypes,
                codeIndexEnd: _this.user.huiyuandengjiTypes,
            })
            if(huiyuandengjiTypesRes.data.list.length >0){
                _this.zhekou = Number(huiyuandengjiTypesRes.data.list[0].beizhu);
            }


        },
        methods: {
			shijianduanTypesChange(e) {
				this.shijianduanTypesIndex = e.target.value
				this.shijianduanValue = this.shijianduanTypesOptions[this.shijianduanTypesIndex].indexName
				this.shijianduanTypes = this.shijianduanTypesOptions[this.shijianduanTypesIndex].codeIndex
			},
			toggleTab(str) {
				this.$refs[str].show();
			},
			yishengOrderTimeConfirm(val) {
				this.yishengOrderTime = val.result;
				this.$forceUpdate();
			},
            async onSubmitTap() {
                let _this = this;
                let table = uni.getStorageSync("nowTable");
                uni.showModal({
                    title: '提示',
                    content: '是否确认支付',
                    success: async function(res) {
                        if (res.confirm) {
							 let data = {
								 yishengs: JSON.stringify(_this.orderGoods),
								 yonghuId: _this.user.id,
								 yishengOrderPaymentTypes:  _this.yishengOrderPaymentTypes,
								 yishengOrderTime:_this.yishengOrderTime,
								 shijianduanTypes:_this.shijianduanTypes
							 }
							await _this.$api.requestConditionDataGet('yishengOrder','order',null,data);
                            _this.$utils.jump('/pages/yishengOrder/list');
                        }
                    }
                });
            },
        }
    }
</script>

<style lang="scss">
    .avator {
        width: 150upx;
        height: 150upx;
        margin: 20upx 0;
    }
</style>
