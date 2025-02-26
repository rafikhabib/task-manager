import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnChanges,
  SimpleChanges,
} from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TaskService, Task } from '../../task.service';

@Component({
  selector: 'app-task-form',
  templateUrl: './task-form.component.html',
  styleUrls: ['./task-form.component.css'],
})
export class TaskFormComponent implements OnChanges {
  taskForm: FormGroup;
  @Input() selectedTask: Task | null = null;
  @Output() taskUpdated = new EventEmitter<void>(); // Emit event to refresh task list
  isEditing = false;

  constructor(private fb: FormBuilder, private taskService: TaskService) {
    this.taskForm = this.fb.group({
      id: [null],
      title: ['', Validators.required],
      description: ['', Validators.required],
      status: ['Pending', Validators.required],
      dueDate: ['', Validators.required],
    });
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['selectedTask'] && this.selectedTask) {
      this.taskForm.patchValue(this.selectedTask);
      this.isEditing = true;
    }
  }

  onSubmit() {
    if (this.taskForm.valid) {
      const task: Task = this.taskForm.value;
      if (this.isEditing) {
        this.taskService.updateTask(task).subscribe(() => {
          alert('Task updated successfully!');
          this.taskUpdated.emit(); // Notify parent to refresh task list
          this.resetForm();
        });
      } else {
        this.taskService.createTask(task).subscribe(() => {
          alert('Task created successfully!');
          this.taskUpdated.emit(); // Notify parent to refresh task list
          this.resetForm();
        });
      }
    }
  }

  resetForm() {
    this.taskForm.reset();
    this.isEditing = false;
    this.selectedTask = null;
  }

  cancelEdit() {
    this.resetForm();
  }
}
