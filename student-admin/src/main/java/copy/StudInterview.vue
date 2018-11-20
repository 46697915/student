
formData: {
id: '',
studId: '',
studName: '',
comName: '',
comXz: '',
comAdress: '',
interviewGw: '',
comGm: '',
zpGm: '',
interviewDate: '',
interviewLc: '',
interviewComment: '',
linkMail: '',
linkPhone: '',
isChannel: '',
channelManager: '',
resume: '',
passingDifficulty: '',
isRecommend: '',
isWritten: '',
remark: ''
},

addUrl: this.domain.serverpath + "/studInterview/add"

    <el-table-column prop="id" label="字段" width="80" ></el-table-column>
    <el-table-column prop="studId" label="字段" width="80" ></el-table-column>
    <el-table-column prop="studName" label="字段" width="80" ></el-table-column>
    <el-table-column prop="comName" label="字段" width="80" ></el-table-column>
    <el-table-column prop="comXz" label="字段" width="80" ></el-table-column>
    <el-table-column prop="comAdress" label="字段" width="80" ></el-table-column>
    <el-table-column prop="interviewGw" label="字段" width="80" ></el-table-column>
    <el-table-column prop="comGm" label="字段" width="80" ></el-table-column>
    <el-table-column prop="zpGm" label="字段" width="80" ></el-table-column>
    <el-table-column prop="interviewDate" label="字段" width="80" ></el-table-column>
    <el-table-column prop="interviewLc" label="字段" width="80" ></el-table-column>
    <el-table-column prop="interviewComment" label="字段" width="80" ></el-table-column>
    <el-table-column prop="linkMail" label="字段" width="80" ></el-table-column>
    <el-table-column prop="linkPhone" label="字段" width="80" ></el-table-column>
    <el-table-column prop="isChannel" label="字段" width="80" ></el-table-column>
    <el-table-column prop="channelManager" label="字段" width="80" ></el-table-column>
    <el-table-column prop="resume" label="字段" width="80" ></el-table-column>
    <el-table-column prop="passingDifficulty" label="字段" width="80" ></el-table-column>
    <el-table-column prop="isRecommend" label="字段" width="80" ></el-table-column>
    <el-table-column prop="isWritten" label="字段" width="80" ></el-table-column>
    <el-table-column prop="remark" label="字段" width="80" ></el-table-column>

<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="id">
        <el-input v-model="formData.id"></el-input>
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
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="comName">
        <el-input v-model="formData.comName"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="comXz">
        <el-input v-model="formData.comXz"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="comAdress">
        <el-input v-model="formData.comAdress"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="interviewGw">
        <el-input v-model="formData.interviewGw"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="comGm">
        <el-input v-model="formData.comGm"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="zpGm">
        <el-input v-model="formData.zpGm"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="interviewDate">
        <el-input v-model="formData.interviewDate"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="interviewLc">
        <el-input v-model="formData.interviewLc"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="interviewComment">
        <el-input v-model="formData.interviewComment"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="linkMail">
        <el-input v-model="formData.linkMail"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="linkPhone">
        <el-input v-model="formData.linkPhone"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="isChannel">
        <el-input v-model="formData.isChannel"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="channelManager">
        <el-input v-model="formData.channelManager"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="resume">
        <el-input v-model="formData.resume"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="passingDifficulty">
        <el-input v-model="formData.passingDifficulty"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="isRecommend">
        <el-input v-model="formData.isRecommend"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="isWritten">
        <el-input v-model="formData.isWritten"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="remark">
        <el-input v-model="formData.remark"></el-input>
        </el-form-item>
    </el-col>
</el-row>
