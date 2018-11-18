
formData: {
id: '',
comName: '',
comAddress: '',
workContent: '',
inDate: '',
outDate: '',
linkMan: '',
comCity: '',
workXz: '',
workSshy: '',
remarks: '',
operator: '',
operatedate: '',
studId: '',
studName: ''
},

addUrl: this.domain.serverpath + "/studWork/add"

    <el-table-column prop="id" label="字段" width="55" v-if="false"></el-table-column>
    <el-table-column prop="comName" label="字段" width="55" ></el-table-column>
    <el-table-column prop="comAddress" label="字段" width="55" ></el-table-column>
    <el-table-column prop="workContent" label="字段" width="55" ></el-table-column>
    <el-table-column prop="inDate" label="字段" width="55" ></el-table-column>
    <el-table-column prop="outDate" label="字段" width="55" ></el-table-column>
    <el-table-column prop="linkMan" label="字段" width="55" ></el-table-column>
    <el-table-column prop="comCity" label="字段" width="55" ></el-table-column>
    <el-table-column prop="workXz" label="字段" width="55" ></el-table-column>
    <el-table-column prop="workSshy" label="字段" width="55" ></el-table-column>
    <el-table-column prop="remarks" label="字段" width="55" ></el-table-column>
    <el-table-column prop="operator" label="字段" width="55" ></el-table-column>
    <el-table-column prop="operatedate" label="字段" width="55" ></el-table-column>
    <el-table-column prop="studId" label="字段" width="55" ></el-table-column>
    <el-table-column prop="studName" label="字段" width="55" ></el-table-column>

<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="id">
        <el-input v-model="formData.id"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="comName">
        <el-input v-model="formData.comName"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="comAddress">
        <el-input v-model="formData.comAddress"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="workContent">
        <el-input v-model="formData.workContent"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="inDate">
        <el-date-picker type="date" v-model="formData.inDate" style="width: 100%;"
                        format="yyyy-MM-dd"
                        value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="outDate">
        <el-date-picker type="date" v-model="formData.outDate" style="width: 100%;"
                        format="yyyy-MM-dd"
                        value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="linkMan">
        <el-input v-model="formData.linkMan"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="comCity">
        <el-input v-model="formData.comCity"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="workXz">
        <el-input v-model="formData.workXz"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="workSshy">
        <el-input v-model="formData.workSshy"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="remarks">
        <el-input v-model="formData.remarks"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="operator">
        <el-input v-model="formData.operator"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="operatedate">
        <el-date-picker type="date" v-model="formData.operatedate" style="width: 100%;"
                        format="yyyy-MM-dd"
                        value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="studId">
        <el-input v-model="formData.studId"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="studName">
        <el-input v-model="formData.studName"></el-input>
        </el-form-item>
    </el-col>
</el-row>
