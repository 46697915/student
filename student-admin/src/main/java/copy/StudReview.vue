
formData: {
id: '',
teacherName: '',
teacherId: '',
teacherType: '',
studId: '',
studName: '',
courseId: '',
courseName: '',
courseBegin: '',
courseEnd: '',
skillLevel: '',
gtLevel: '',
reviewScore: '',
reviewContent: '',
reviewDate: '',
tjFx: '',
tjCom: '',
tjGw: '',
remark: ''
},

addUrl: this.domain.serverpath + "/studReview/add"

    <el-table-column prop="id" label="字段" width="80" v-if="false"></el-table-column>
    <el-table-column prop="teacherName" label="字段" width="80" ></el-table-column>
    <el-table-column prop="teacherId" label="字段" width="80" ></el-table-column>
    <el-table-column prop="teacherType" label="字段" width="80" ></el-table-column>
    <el-table-column prop="studId" label="字段" width="80" ></el-table-column>
    <el-table-column prop="studName" label="字段" width="80" ></el-table-column>
    <el-table-column prop="courseId" label="字段" width="80" ></el-table-column>
    <el-table-column prop="courseName" label="字段" width="80" ></el-table-column>
    <el-table-column prop="courseBegin" label="字段" width="80" ></el-table-column>
    <el-table-column prop="courseEnd" label="字段" width="80" ></el-table-column>
    <el-table-column prop="skillLevel" label="字段" width="80" ></el-table-column>
    <el-table-column prop="gtLevel" label="字段" width="80" ></el-table-column>
    <el-table-column prop="reviewScore" label="字段" width="80" ></el-table-column>
    <el-table-column prop="reviewContent" label="字段" width="80" ></el-table-column>
    <el-table-column prop="reviewDate" label="字段" width="80" ></el-table-column>
    <el-table-column prop="tjFx" label="字段" width="80" ></el-table-column>
    <el-table-column prop="tjCom" label="字段" width="80" ></el-table-column>
    <el-table-column prop="tjGw" label="字段" width="80" ></el-table-column>
    <el-table-column prop="remark" label="字段" width="80" ></el-table-column>

<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="id">
        <el-input v-model="formData.id"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="teacherName">
        <el-input v-model="formData.teacherName"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="teacherId">
        <el-input v-model="formData.teacherId"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="teacherType">
        <el-input v-model="formData.teacherType"></el-input>
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
        <el-form-item label="" prop="courseId">
        <el-input v-model="formData.courseId"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="courseName">
        <el-input v-model="formData.courseName"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="courseBegin">
        <el-input v-model="formData.courseBegin"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="courseEnd">
        <el-input v-model="formData.courseEnd"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="skillLevel">
        <el-input v-model="formData.skillLevel"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="gtLevel">
        <el-input v-model="formData.gtLevel"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="reviewScore">
        <el-input v-model="formData.reviewScore"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="reviewContent">
        <el-input v-model="formData.reviewContent"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="reviewDate">
        <el-date-picker type="date" v-model="formData.reviewDate" style="width: 100%;"
                        format="yyyy-MM-dd"
                        value-format="yyyy-MM-dd"></el-date-picker>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="tjFx">
        <el-input v-model="formData.tjFx"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="tjCom">
        <el-input v-model="formData.tjCom"></el-input>
        </el-form-item>
    </el-col>
    <el-col :span="8">
        <el-form-item label="" prop="tjGw">
        <el-input v-model="formData.tjGw"></el-input>
        </el-form-item>
    </el-col>
</el-row>
<el-row>
    <el-col :span="8">
        <el-form-item label="" prop="remark">
        <el-input v-model="formData.remark"></el-input>
        </el-form-item>
    </el-col>
</el-row>