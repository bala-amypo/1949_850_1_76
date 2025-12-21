@RestController
@RequestMapping("/api/conflict-cases")
@Tag(name = "Conflict Case Controller")
public class ConflictCaseController {
    private final ConflictCaseService service;

    public ConflictCaseController(ConflictCaseService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ConflictCase createCase(@RequestBody ConflictCase conflictCase) { return service.createCase(conflictCase); } [cite: 149]

    @PutMapping("/{id}/status")
    public ConflictCase updateStatus(@PathVariable Long id, @RequestParam String status) {
        return service.updateCaseStatus(id, status); [cite: 150]
    }

    @GetMapping("/person/{personId}")
    public List<ConflictCase> getByPerson(@PathVariable Long personId) { return service.getCasesByPerson(personId); } [cite: 151]

    @GetMapping("/{id}")
    public ConflictCase getById(@PathVariable Long id) { return service.getCaseById(id); } [cite: 152]
}