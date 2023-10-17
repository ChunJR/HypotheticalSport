import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.chun.hypotheticalsport.data.remote.SportApi
import com.chun.hypotheticalsport.domain.model.Team
import com.chun.hypotheticalsport.domain.usecases.UseCases
import com.chun.hypotheticalsport.presentation.team.TeamState
import com.chun.hypotheticalsport.presentation.team.TeamViewModel
import com.chun.hypotheticalsport.remote.FakeSportApi
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltAndroidTest
class TeamViewModelTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var useCases: UseCases

    private lateinit var viewModel: TeamViewModel

    private lateinit var teams: List<Team>
    private lateinit var sportApi: SportApi

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        hiltRule.inject()
        sportApi = FakeSportApi()
        viewModel = TeamViewModel(useCases)
        teams = listOf(
            Team(
                id = "767ec50c-7fdb-4c3d-98f9-d6727ef8252b",
                name = "Team Red Dragons",
                logo = "https://tstzj.s3.amazonaws.com/dragons.png",
            ),
            Team(
                id = "7b4d8114-742b-4410-971a-500162101158",
                name = "Team Cool Eagles",
                logo = "https://tstzj.s3.amazonaws.com/eagle.png",
            ),
            Team(
                id = "efb06ca2-78bc-448e-bda5-a6af9eccdcd0",
                name = "Team Chill Elephants",
                logo = "https://tstzj.s3.amazonaws.com/elephant.png",
            ),
        )
    }

    @Test
    fun `test uiState emits Loading state initially`() = runTest {
        // Arrange
        val expectedState = TeamState.Loading

        // Act
        val actualState = viewModel.uiState.value

        // Assert
        assertEquals(expectedState, actualState)
    }

    @Test
    fun `test uiState emits teams state after fetching data successfully`() = runTest {
            // Arrange
            val expectedState = TeamState.Success(teams)
            val stateFlow = MutableStateFlow<TeamState>(TeamState.Loading)

            // Mock the use case's result
            `when`(useCases.getAllTeamsUseCase()).thenReturn(stateFlow)

            // Act
            viewModel.uiState.collect { state ->
                stateFlow.value = expectedState
            }

            // Assert
            val actualState = viewModel.uiState.value
            assertEquals(expectedState, actualState)
        }
}